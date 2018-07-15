window.index = (function($,module){
	
	var cur = {};
	
	cur.event = function(){
		$("ul.nav li").click(function(){
			$("ul.nav li").removeClass("active");
			$(this).addClass("active");
		});
	}
	module.cur = cur;
	return module;
})($,window.index || {})

$(document).ready(function(){
	index.cur.event();
});

//@sourceuri index.js