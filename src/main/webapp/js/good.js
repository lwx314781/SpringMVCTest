window.good = (function($,module){
	var $_table = $("#table");
	var $_pager = "#pager";
	var _gird = null;
	
	function init(){
		initJqgrid();
		$(window).off("resize").on("resize",function(){
			var width = $(window).width()*0.98;
			_gird.setGridWidth(width);
		});
	}
	
	function initJqgrid(){
		_gird = $_table.jqGrid({
			   	url : '../goods/queryList.do',
			   	type : 'post',
			   	headers: {
					"Accept": "application/json",
		            "Content-Type": "application/json;charset=utf-8"
		        },
				datatype: "json",
			   	colNames:['序号','产品名称', '价格', '图片','format'],
			   	colModel:[
			   		{name:'id',index:'id', width:55},
			   		{name:'name',index:'name', width:90},
			   		{name:'price',index:'price', width:100},
			   		{name:'picture',index:'picture', width:80, align:"right"},
			   		
			   		{name: 'format',
			   		 index:'format',
			   		 width:100,
		   			 formatter:function(cellvalue, options, rowObject){
		   				 if (options["rowId"]%2==0){
		   					 return "<button>删除</button>"
		   				 }else{
		   					return "<button style='color: red;'>删除</button>"
		   				 }
			   		      
		   			     },
			   		}
			   	],
			   	caption : "货物清单",
			   	rowNum:10,
			   	rowList:[10,20,30],
			   	pager: $_pager,
			   	multiselect : true,
			   	sortname: 'id',
			    viewrecords: true,
			    sortorder: "desc",
			    height: 220,
			    autowidth: true,
			    prmNames : {
			    	page : "currentNo",
			    	rows : "rows",
			    	sort : "sidx",
			    	order : "sord",
			    	nd : "nd",
			    	search : "_search"
			    },
			    jsonReader: {
			    	root: "list", 
			    	page: "currentNo", 
			    	total: "count", 
			    	records: "rows", 
					repeatitems : false,
					id: "0"
				},
				gridComplete : function(){
					$_table.closest("div.ui-jqgrid-view")
					.children("div.ui-jqgrid-titlebar")
					.css("text-align", "center")
					.children("span.ui-jqgrid-title")
					.css("font-size","20")
				}
			});
	}
	module.init = init;
	return module;
	
})($,window.good || {})

$(function(){
	jQuery.browser={};
	(function(){jQuery.browser.msie=false; 
	jQuery.browser.version=0;
	if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;}})();
	
	good.init();
});
//@sourceURL=good.js