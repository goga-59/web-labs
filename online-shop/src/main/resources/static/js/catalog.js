document.addEventListener("DOMContentLoaded", function () {
    let productSelect = document.getElementById("product");
    let quantityInput = document.getElementById("quantity");
    let totalPriceField = document.getElementById("total-price");
    let orderFormModal = document.getElementById("order-form-modal");
    let openOrderFormButton = document.getElementById("open-order-form");
    let totalPriceInput = document.getElementById("total-price-input")
    let closeButton = document.querySelector(".close-button");

    function updateForm() {
        let selectedOption = productSelect.options[productSelect.selectedIndex];
        let pricePerUnit = parseFloat(selectedOption.getAttribute("data-price").toString().replace(/,/g,"")) || 0;
        let quantity = parseInt(quantityInput.value) || 0;
        let total = pricePerUnit * quantity;
        totalPriceField.textContent = total + " руб.";
        totalPriceInput.value = total
    }

    openOrderFormButton.addEventListener("click", function () {
        orderFormModal.style.display = "flex";
    });

    closeButton.addEventListener("click", function () {
        orderFormModal.style.display = "none";
    });

    productSelect.addEventListener("change", updateForm);
    quantityInput.addEventListener("input", updateForm);

    updateForm();
});