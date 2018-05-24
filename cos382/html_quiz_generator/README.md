# Quiz Generator (Domain-Specific Language)

## Assignment Purpose

The purpose of this assignment was to create a domain-specific language. We
chose to create an HTML quiz generator, that given a text file with a simple
format, it would produce an HTML quiz.

## Setup

1. Set up your IDE to accept 3 command line arguments. It needs to accept an
   existing source file (e.g. quiz.txt), the name of the output html file (e.g.
   quiz.html), and the name of the output js file (quizAnswers.js).
2. Run the QuizGen.java in your preferred IDE. 
3. Upon running this file, it should create the html and js output files that
   were named in the arguments.
4. Depending on the IDE, one might have to include file pathnames in the
   arguments when referencing files.
5. Depending on the IDE, they might need to examine/edit the source of the
   quiz.html file and correct the filepath in the following line:
   `<script src="src/answers.js"></script>`.
6. Navigate to where the quiz.html is located and open it in your browser. The
   quiz should appear, as seen in the screenshot:
   [Before Grading](img/webpage.png).
7. Take the quiz and click submit to see your grade like in the screenshot:
   [After Grading](img/showing_grade.png).
8. If the submit button does nothing, go back to the html file and double check
   the `<script src="src/answers.js"></script>` to make sure it has the correct filepath.

## Example Input

```txt
(OP)
| TITLE = Example Quiz
| SCRAMBLE_CHOICES = True
| SCRAMBLE_QUESTIONS = True
| QUESTION_COUNT = 2

What is the meaning of life?
| Tim Parr
> 42
| Dr. Denning
| Computer Science

Who is the best computer science professor?
| Dr. White
| Dr. Stanley
> Dr. Denning
| Alan Turing

What is the best major at Taylor?
| Professional Writing
> Alan Turing
| Underwater Basket Weaving
| Computer Science
```

## Example Output: HTML and JS

```html
<!DOCTYPE html>
<html>
<head>
    <script src="src/answers.js"></script>
    <meta charset="utf-8">
    <title>Example Quiz</title>
</head>

<body>
    <h1>Example Quiz</h1>

    <div id="gradeSection" hidden>
        <h3 id="grade"></h3>
    </div>

    <div>
        <p>Who is the best computer science professor?</p>
        <input type="radio" name="mc2" value="a">
        <label> Dr. Denning</label><br>
        <input type="radio" name="mc2" value="b">
        <label> Alan Turing</label><br>
        <input type="radio" name="mc2" value="c">
        <label> Dr. White</label><br>
        <input type="radio" name="mc2" value="d">
        <label> Dr. Stanley</label><br>
    </div><br>
    <div>
        <p>What is the best major at Taylor?</p>
        <input type="radio" name="mc3" value="a">
        <label> Computer Science</label><br>
        <input type="radio" name="mc3" value="b">
        <label> Underwater Basket Weaving</label><br>
        <input type="radio" name="mc3" value="c">
        <label> Alan Turing</label><br>
        <input type="radio" name="mc3" value="d">
        <label> Professional Writing</label><br>
    </div><br>
    <div>
        <p>What is the meaning of life?</p>
        <input type="radio" name="mc1" value="a">
        <label> Computer Science</label><br>
        <input type="radio" name="mc1" value="b">
        <label> Tim Parr</label><br>
        <input type="radio" name="mc1" value="c">
        <label> 42</label><br>
        <input type="radio" name="mc1" value="d">
        <label> Dr. Denning</label><br>
    </div><br>
    <input type="submit" id="submit" onClick="submitQuiz();">
</body>
</html>```

```js
var problemNumbers = [2, 3, 1];
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
```

## Credit

- **Assignment Author**: Dr. Jonathan Denning, PhD
- **Assignment Partners**: Sean Mitchem, Tim Parr