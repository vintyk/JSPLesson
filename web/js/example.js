function printInputToConsole() {
    // # - это поиск нашего элемента по id
    // val - это функция в токотой - наше значение
    let inputValue = $("#data-input").val();
    console.log(inputValue);
}

function printByJS() {
    let el = document.getElementById("msg");
    let myText = document.getElementById("data-input").value;
    console.log(myText);
    let tag = document.createElement("h2");
    tag.innerText = myText;
    el.appendChild(tag);
}

function sendInputDataToServer() {
    let el1 = document.getElementById("msg");
    let name = document.getElementById("data-input").value;
    let family = document.getElementById("data-input2").value;
    let tag1 = document.createElement("h2");
    let tag2 = document.createElement("h2");
    tag1.innerText = name + " " + family;
    // tag2.innerText = family;
    el1.appendChild(tag1);
    // el1.appendChild(tag2);

    $.ajax({
        url: '/jqueryExample',
        method: 'post',
        data: JSON.stringify({
            name: name,
            family: family
        })
    })
}