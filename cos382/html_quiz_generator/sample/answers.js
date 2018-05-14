var problemNumbers = [2, 1, 3];
var correctAnswers = ['b', 'c', 'b'];

function calcScore() {
	var numCorrect = 0;

	for (var i = 0; i < problemNumbers.length; i++) {
		var idx = problemNumbers[i]-1;
		var correctAnswer = correctAnswers[idx];

		var selectedElement;
		var correctElement;
		var choices = document.getElementsByName("mc"+problemNumbers[i]);
		for (var j = 0; j < choices.length; j++) {
			if (choices[j].checked) {
				selectedElement = choices[j];
			}

			if (choices[j].value === correctAnswer) {
				correctElement = choices[j];
			}
		}

		if (selectedElement.value === correctAnswer) {
			selectedElement.nextElementSibling.style.color = "green";
			numCorrect++;
		} else {
			selectedElement.nextElementSibling.style.color = "red";
			correctElement.nextElementSibling.style.color = "lightgreen";
		}
	}

	return numCorrect;
}

function submitQuiz() {
	var numCorrect = calcScore();
	var total = problemNumbers.length;
	var percent = Math.round(numCorrect/total*100);
	document.getElementById("grade").innerHTML = `Your grade: ${numCorrect}/${total} (${percent}%)`;
	document.getElementById("gradeSection").removeAttribute("hidden");
	document.getElementById("submit").style.visibility = "hidden"
}
