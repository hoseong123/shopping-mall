const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInputs = document.querySelectorAll(".account-input");

    let user = {
        name: accountInputs[0].value,
        email: accountInputs[1].value,
        password: accountInputs[2].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: "json",
        success: (reponse) => {
            console.log(Response);
        },
        error: (error) =>{
            console.log(error.responseJSON.data);
            loadErrorMassege(error.responseJSON.data);
        }


    });

}

function loadErrorMassege(errors) {
    const errorList = document.querySelector(".errors");
    const errorMsgs = document.querySelector(".error-msgs");
    const errorsArray = Object.values(errors)

    errorMsgs.innerHTML = "";

    errorsArray.forEach(error =>{
        errorMsgs.innerHTML += `
            <li>${error}</li>
        `;
    })

    errorList.classList.remove("errors-invisible");
}
