/*$(document).ready(function() {
        $('#userName').blur(function(event) {
               var name = $('#userName').val();
               $.get('GetUserServlet', {
                       userName : name
               }, function(responseText) {
                       $('#ajaxGetUserServletResponse').text(responseText);
               });
        });
});*/


$(document).ready(function() {
	
	
	//alert("called");
	
	
	
	$('#serial').change(function() {
		var t=$('#serial').val()
		//alert("hhh"+t);
		
		//alert("hello");
		var res=null;
		//$('#link').show();
		$.ajax({
			url : 'jslogic.jsp',
			data : {
				dist : $('#serial').val(),
				f : $('#fid').val()
			},
			success : function(jsonResponse) {
				var select= $('#hname')
				select.find('option').remove();
				$.each(jsonResponse, function(index, value) {
						//alert("pp="+value);
						if(value.equals("T")){
							res="T";
						}
					
				//	$('#hname').val(value);
				      });
				/*$('#ajaxGetUserServletResponse').text(jsonResponse);*/
			}
		});
		
		
	});
	
	
});


