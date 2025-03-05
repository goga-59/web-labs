function updateButtons() {
    let from = parseInt(document.getElementById("from").value);
    let buttons = document.querySelectorAll(".digit-button");

    buttons.forEach(button => {
        let buttonValue = parseInt(button.innerText, 16);
        button.disabled = isNaN(from) || buttonValue >= from;
    });
    clearInput();
}

function appendDigit(digit) {
    document.getElementById("numberInput").value += digit;
}

function deleteDigit() {
    let inputField = document.getElementById("numberInput").value
    if (inputField !== "") {
        inputField = inputField.slice(0, -1)
    }
    document.getElementById("numberInput").value = inputField
}

function clearInput() {
    document.getElementById("numberInput").value = "";
    document.getElementById("result").innerText = "";
}

function convertNumber() {
    let number = document.getElementById("numberInput").value;
    let from = parseInt(document.getElementById("from").value);
    let to = parseInt(document.getElementById("to").value);
    let result = document.getElementById("result");

    if (!from || !to) {
        result.innerText = "Выберите системы счисления";
        return;
    }

    if (!number) {
        document.getElementById("result").innerText = "Введите число";
        return;
    }

    try {
        let decimalValue = parseInt(number, from);
        result.innerText = decimalValue.toString(to).toUpperCase();
    } catch (error) {
        document.getElementById("result").innerText = "Ошибка ввода";
    }
}