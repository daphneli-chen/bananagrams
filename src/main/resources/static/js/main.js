/**
 * Front end logic for providing real time autocorrect suggestions.
 */

$(document).ready(() => {
  const suggestionList = $("#suggestions");
  const input = $('#autocorrect-input');

  input.keyup(event => {
    suggestionList.empty();
    const postParameters = {
      text: input.val()
    };
    console.log(postParameters);
    $.post('/autocorrectResults', postParameters, responseJSON => {
      const responseObject = JSON.parse(responseJSON);
      for(let ele of responseObject.results){
        suggestionList.append('<li tabindex="0">' + ele + '</li>');
      }
      let listElements = document.getElementsByTagName("li");
      for(let s of listElements){
        s.addEventListener("click", suggestionClicked);
      }
      function suggestionClicked(e){
        input.val(e.target.innerHTML);
      }

    })
  });
});