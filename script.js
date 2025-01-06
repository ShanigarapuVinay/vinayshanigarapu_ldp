let localScore = localStorage.getItem('localScore') ? parseInt(localStorage.getItem('localScore')) : 0;
let sessionScore = sessionStorage.getItem('sessionScore') ? parseInt(sessionStorage.getItem('sessionScore')) : 0;

document.getElementById('localScore').innerText = localScore;
document.getElementById('sessionScore').innerText = sessionScore;

let btn = document.getElementById("incrementButton");

btn.addEventListener('click', () => {
    localScore++;
    sessionScore++;
    localStorage.setItem("localScore", localScore);
    sessionStorage.setItem("sessionScore", sessionScore);

    document.getElementById('localScore').innerText = localScore;
    document.getElementById('sessionScore').innerText = sessionScore;
})