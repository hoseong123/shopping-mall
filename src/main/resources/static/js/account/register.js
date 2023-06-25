const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInputs = document.querySelectorAll(".account-input");

    let user = {
        name: accountInputs[0].value,
        email: accountInputs[1].value,
        password: accountInputs[2].value
    }

    let ajaxOption = {
        async: false,
        type: "post",
        url: "/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: "json",
        succss: (reponse) => {
            alert("회원가입 요청 성공");
            console.log(Response);
        },
        error: (request, status, error) =>{
            alert("회원가입 요청 실패");
            console.log(error.responseJSON.name);
        }


    }

    $.ajax(ajaxOption);
}
