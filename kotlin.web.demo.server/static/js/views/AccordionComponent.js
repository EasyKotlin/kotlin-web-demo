/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created with IntelliJ IDEA.
 * User: Natalia.Ukhorskaya
 * Date: 3/30/12
 * Time: 3:37 PM
 */

var AccordionView = (function () {
    function AccordionView(element) {
        element.html("");
        element.accordion({
            heightStyle: "content",
            navigation: true,
            active: 0,
            icons: {
                activeHeader: "examples-open-folder-icon",
                header: "examples-closed-folder-icon"
            }
        });
//        var programsView = new ProgramsView(programsModel);

        var downloadedProjects = {};
        var selectedProject = null;
        var instance = {
            onLoadExampleHeaders: function (data) {
                if (Object.prototype.toString.call(data) === '[object Array]') {
                    for (var i = 0; i < data.length; i++) {
                        addFolder(data[i]);
                    }
                }
                addMyProjectsFolder();
                element.accordion("refresh");
                element.accordion("option", "active", 0);
                loadFirstItem();
            },
            onLoadUserProjectsHeaders: function (data) {
                for (var i = 0; i < data.length; i++) {
                    addProject("My Programs", document.getElementById("My_Programs_content"), data[i]);
                }
                addNewProjectButton();
            },
            saveProject: function () {
                selectedProject.save();
            },
            loadAllContent: function () {
                element.html("");
                headersProvider.getAllExamples();
            },
            addNewProject: function (name, /*nullable*/ content) {
                addNewProject(name, content);
            },
            onLoadCode: function (example, isProgram) {
            },
            onSaveProgram: function () {
            },
            deleteProject: function (url) {
                deleteProject(url);
            },
            onFail: function (exception, messageForStatusBar) {
            },
            onLogout: function () {
                downloadedProjects = {};
                selectedProject = null;
                instance.loadAllContent();
            },
            getSelectedProject: function () {
                return selectedProject;
            }
        };

        var headersProvider = (function () {
            return new AccordionHeadersProvider(instance.onLoadExampleHeaders, instance.onLoadUserProjectsHeaders, instance.onFail);
        })();

        var newProjectDialog = new InputDialogView("Add new project", "Project name:", "Add");

        function createProject(name, contentElement, content) {
            var url = getProjectURL("My Programs", name);
            if (content == null) {
                var filename = name.endsWith(".kt") ? name : name +".kt";
                content = {
                    name: name,
                    parent: "My Program",
                    args: "",
                    confType: "java",
                    help: "",
                    files: [
                        {name: filename, content: "", modifiable: true}
                    ]
                }
            }
            downloadedProjects[url] = new Project(url, contentElement, content);
        }

        function loadFirstItem() {
            var openedItemUrl = localStorage.getItem("openedItemUrl");
            localStorage.removeItem("openedItemUrl");
            if(openedItemUrl != null && document.getElementById(openedItemUrl) != null){
                document.getElementById(openedItemUrl).parentNode.parentNode.previousSibling.click();
                document.getElementById(openedItemUrl).click();
            } else{
                element.accordion('option', 'active', 0);
                element.children()[1].children[0].click();
            }
        }


        function addNewProjectButton() {
            var cont = document.getElementById("My_Programs_content");

            var addNewProjectDiv = document.createElement("div");
            addNewProjectDiv.id = "add_new_project";

            var addNewProjectIcon = document.createElement("div");
            addNewProjectIcon.innerHTML = "+";
            addNewProjectDiv.appendChild(addNewProjectIcon);

            var addNewProjectText = document.createElement("div");
            addNewProjectText.innerHTML = "Add new project";
            addNewProjectText.className = "examples-project-name";
            addNewProjectText.style.cursor = "pointer";
            addNewProjectDiv.appendChild(addNewProjectText);

            addNewProjectDiv.onclick = newProjectDialog.open.bind(null, headersProvider.addNewProject);
            cont.appendChild(addNewProjectDiv);
        }


        function createProjectHeader(folder, name) {
            var projectHeader = document.createElement("h4");
            projectHeader.className = "examples-project-name";
            var img = document.createElement("div");
            img.className = "arrow";
            projectHeader.appendChild(img);
            projectHeader.id = createExampleUrl(name, folder) + "_header";
            projectHeader.onclick = function(event){
                onProjectHeaderClick(this.id.substring(0, this.id.indexOf("_header")));
            };


            var nameSpan = document.createElement("span");
            nameSpan.id = createExampleUrl(name, folder);
            nameSpan.className = "file-name-span";
            nameSpan.style.cursor = "pointer";
            nameSpan.onclick = function (event) {
                onProjectHeaderClick(this.id);
                event.stopPropagation();
            };
            nameSpan.innerHTML = name;
            projectHeader.appendChild(nameSpan);

            if (folder == "My Programs") {
                var deleteButton = document.createElement("div");
                deleteButton.className = "delete-img";
                deleteButton.title = "Delete this project";
                deleteButton.onclick = (function (url) {
                    return function (event) {
                        headersProvider.deleteProject(url);
                        event.stopPropagation();
                    }
                })(createExampleUrl(name, folder));
                projectHeader.appendChild(deleteButton);
            }

            return projectHeader;
        }

        function addNewProject(name, /*nullable*/ content) {
            var myProg = document.getElementById("My_Programs_content");
            var newProjectNode = myProg.lastChild;
            myProg.insertBefore(createProjectHeader("My Programs", name), newProjectNode);


            var exampleContent = document.createElement("div");
            exampleContent.id = createExampleUrl(name, "My Programs") + "_content";
            myProg.insertBefore(exampleContent, newProjectNode);


            createProject(name, exampleContent, content);
            document.getElementById(getProjectURL("My Programs", name)).click();
        }

        function addProject(folder, element, name) {
            element.appendChild(createProjectHeader(folder, name));

            var exampleContent = document.createElement("div");
            exampleContent.id = createExampleUrl(name, folder) + "_content";
            element.appendChild(exampleContent);
        }

        function deleteProject(url) {
            var header = document.getElementById(url + "_header");
            header.parentNode.removeChild(header);

            var project = downloadedProjects[url];
            if (project != null) {
                project.onDelete();
                if(project == selectedProject) {
                    selectedProject = null;
                    var myPrograms = document.getElementById("My_Programs_content");
                    if(myPrograms.firstElementChild.id == "add_new_project"){
                        loadFirstItem();
                    } else{
                        myPrograms.firstChild.click();
                    }
                }
            }
            delete downloadedProjects[url];
        }

        function addFolder(data) {
            var folder = document.createElement("h3");
            var folderDiv = document.createElement("div");
            folder.className = "examples-folder-name";

            folderDiv.innerHTML = data.name;
            folderDiv.className = "folder-name-div";

            folder.appendChild(folderDiv);
            element.append(folder);
            var cont = document.createElement("div");
            var i = 0;
            while (data.examplesOrder[i] != undefined) {
                addProject(data.name, cont, data.examplesOrder[i]);
                i++;
            }

            element.append(cont);
        }

        function addMyProjectsFolder() {
            var myProg = document.createElement("h3");
            myProg.className = "examples-folder-name";
            myProg.innerHTML = "My programs";


            if (!loginView.isLoggedIn()) {
                myProg.style.color = "rgba(0,0,0,0.5)";
                $("#save").attr("title", "Save your program(you must be logged in)");
                var login_link = document.createElement("span");
                login_link.id = "login-link";
                login_link.className = "login-link";
                login_link.innerHTML = "(please log in)";
                element.find("#login_link").click(function (event) {
                    $("#login-dialog").dialog("open");
                    event.stopPropagation()
                });
                myProg.appendChild(login_link);
            }


            element.append(myProg);
            element.find(".login-link").click(function (event) {
                $("#login-dialog").dialog("open");
                event.stopPropagation()
            });
            var myProgCont = document.createElement("div");
            myProgCont.id = "My_Programs_content";
            element.append(myProgCont);
            if (loginView.isLoggedIn()) {
                headersProvider.getAllPrograms();
            }
        }

        function onProjectHeaderClick(url) {
            var element;
            if (downloadedProjects[url] == undefined) {
                if (selectedProject != null) {
                    selectedProject.save();
                    element = document.getElementById(selectedProject.getURL() + "_header");
                    element.className = "examples-project-name";
                    $(element).next().slideUp();
                }
                var content = document.getElementById(url + "_content");
                downloadedProjects[url] = new Project(url, content);
                selectedProject = downloadedProjects[url];
            } else if (downloadedProjects[url] != selectedProject) {
                if (selectedProject != null) {
                    selectedProject.save();
                    element = document.getElementById(selectedProject.getURL() + "_header");
                    element.className = "examples-project-name";
                    $(element).next().slideUp();
                }
                selectedProject = downloadedProjects[url];
                element = document.getElementById(selectedProject.getURL() + "_header");
                element.className = "expanded-project-name";
                $(element).next().slideDown();
                selectedProject.select();
            } else {
                element = document.getElementById(selectedProject.getURL() + "_header");
                if (element.className.indexOf("expanded-project-name") > -1) {
                    element.className = "current-project-name";
                    $(element).next().slideUp()
                } else {
                    element.className = "expanded-project-name";
                    $(element).next().slideDown()
                }
            }

//            $("span[id='" + ExamplesView.getLastSelectedItem() + "']").parent().attr("class", "selected-example");
        }

        function getProjectURL(parent, name) {
            return replaceAll(parent, " ", "_") + "&name=" + replaceAll(name, " ", "_");
        }

        return instance;
    }


    return AccordionView;
})();
