angular.module('studentApp', []).controller('StudentController', function($scope, $http) {
    //get all students
    $http.get('/api/students')
    .then(function(response) {
        $scope.students = response.data;
    });
});

//display the forms with the information from the selected table row
function openAddPopup() {
    document.getElementById("add-name").value = "";
    document.getElementById("add-pattern-ready").checked = false;
    document.getElementById("add-definition-ready").checked = false;
    document.getElementById("add-student-ready").checked = false;
    document.getElementById("add-test-paid").checked = false;

    const popupBackground = document.getElementById("popup-background");
    const popup = document.getElementById("add-student-popup");
    popupBackground.style.display = "block";
    popup.style.display = "block";
}
function openEditPopup(studentJson) {
    const student = JSON.parse(studentJson);
    const popupBackground = document.getElementById("popup-background");
    const popup = document.getElementById("edit-student-popup");
    document.getElementById("edit-student-id").value = student.id;
    document.getElementById("edit-name").value = student.name;
    document.getElementById("edit-pattern-ready").checked = student.patternReady;
    document.getElementById("edit-definition-ready").checked = student.definitionReady;
    document.getElementById("edit-student-ready").checked = student.studentReady;
    document.getElementById("edit-test-paid").checked = student.testPaid;
    popupBackground.style.display = "block";
    popup.style.display = "block";
}
function openDeletePopup(studentJson) {
    const student = JSON.parse(studentJson);
    const popupBackground = document.getElementById("popup-background");
    const popup = document.getElementById("delete-student-popup");
    document.getElementById("delete-student-id").value = student.id;
    document.getElementById("delete-name").value = student.name;
    document.getElementById("delete-pattern-ready").checked = student.patternReady;
    document.getElementById("delete-definition-ready").checked = student.definitionReady;
    document.getElementById("delete-student-ready").checked = student.studentReady;
    document.getElementById("delete-test-paid").checked = student.testPaid;
    popupBackground.style.display = "block";
    popup.style.display = "block";
}

//closes popups
function closePopup() {
    const popupBackground = document.getElementById("popup-background");
    const popups = popupBackground.children;
    popupBackground.style.display = "none";
    for (const popup of popups) {
        popup.style.display = "none";
    }
}

//read the form and send a POST, PUT, or DELETE request to the server
function addStudent() {
    const name = document.getElementById("add-name").value;
    const patternReady = document.getElementById("add-pattern-ready").checked;
    const definitionReady = document.getElementById("add-definition-ready").checked;
    const studentReady = document.getElementById("add-student-ready").checked;
    const testPaid = document.getElementById("add-test-paid").checked;

    const student = {
        name: name,
        patternReady: patternReady,
        definitionReady: definitionReady,
        studentReady: studentReady,
        testPaid: testPaid
    };

    fetch('/api/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    })
    .then((response) => {
        if (!response.ok)
            throw new Error(response.status);
        window.location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
function editStudent() {
    const id = document.getElementById("edit-student-id").value;
    const name = document.getElementById("edit-name").value;
    const patternReady = document.getElementById("edit-pattern-ready").checked;
    const definitionReady = document.getElementById("edit-definition-ready").checked;
    const studentReady = document.getElementById("edit-student-ready").checked;
    const testPaid = document.getElementById("edit-test-paid").checked;

    const student = {
        name: name,
        patternReady: patternReady,
        definitionReady: definitionReady,
        studentReady: studentReady,
        testPaid: testPaid
    };

    fetch('/api/students/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    })
    .then((response) => {
        if (!response.ok)
            throw new Error(response.status);
        window.location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
function deleteStudent() {
    const id = document.getElementById("delete-student-id").value;

    fetch('/api/students/' + id, {
        method: 'DELETE'
    })
    .then((response) => {
        if (!response.ok)
            throw new Error(response.status);
        window.location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

//loads a sample of students
function loadSample() {
	fetch('/api/students/sample')
	.then((response) => {
		if (!response.ok)
			throw new Error(response.status);
		window.location.reload();
	})
	.catch((error) => {
		console.error('Error:', error);
	});
}