function printInputToConsole() {
    // # - это поиск нашего элемента по id
    // val - это функция в токотой - наше значение
    let inputValue = $("#data-input").val();
    console.log(inputValue);
}

function printByJS() {
    let el = document.getElementById("msg");
    let myText = document.getElementById("data-input").value;
    let tag = document.createElement("h2");
    tag.innerText = myText;
    el.appendChild(tag);
}