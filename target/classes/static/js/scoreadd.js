/**
 *    添加成绩用的js
 */
/*$.ajax({
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
  type: 'POST',
  dataType: "json", 
  data: JSON.stringify(
		  $("button").click(function(){
		 		$("form").serialize();
	}   )   ),
  url: '/score/insertBacth',
  success: function(){
      alert('success');
  }
});*/

//序列化表单
/*function serialize(form){
    var parts=[],
    field=null,
    i;
    for(i=0;i<form.elements.length;i++){
        field=form.elements[i];
        switch(field.type){
            case "submit":
            case "button":
            case "reset":
                break;
            case "radio":
            case "hidden":
            default:
                if(field.name.length){
                    parts.push(encodeURIComponent(field.name)+"="+encodeURIComponent(field.value));
                }
        }
    }
    return parts;
}*/

