
(function($) {
    $.fn.siderbar = function(option){

        var defaults = {
            url:""
        };

        var settings = $.extend(defaults,option);

        var createNode = function (node) {
            var children = node.children;
            var html = "<li><a class=''><a href='"+node.url+"'><i class='menu-icon fa fa-tachometer'></i>" +
                "<span class='menu-text'>"+node.name+"</span>";
            if(children) {
                html+="<b class='arrow fa fa-angle-down'></b>";
            }
            html+="</a><b class='arrow'></b>";
            if(children) {
                html+="<ul class='submenu'>";
                for(i = 0, l = children.length; i < l; i++) {
                   html+=createNode(children[i]);
                }
                html+="</ul>";
            }
            html+="</li>";

            return html;

        }
        $.ajax({
            type : option.type || 'GET',
            url  : option.url,
            success : function (data, textStatus) {
                var i, l, nodes, key='id', parentKey='pId',childKey='children';
                if(!data) return [];
                if(Object.prototype.toString.apply(data) === "[object Array]"){
                    var r = [];
                    var tmpMap = {};
                    for (i = 0, l = data.length; i < l; i++) {
                        tmpMap[data[i][key]] = data[i];
                    }
                    for (i = 0, l = data.length; i < l; i++) {
                        if (tmpMap[data[i][parentKey]] && data[i][key] != data[i][parentKey]) {
                            if (!tmpMap[data[i][parentKey]][childKey])
                                tmpMap[data[i][parentKey]][childKey] = [];
                            tmpMap[data[i][parentKey]][childKey].push(data[i]);
                        } else {
                            r.push(data[i]);
                        }
                    }
                    nodes = r;
                }
                else {
                    nodes = [data];
                }
                console.log(nodes);
                console.log($(this));

                for(var i=0, l = nodes.length; i < l; i++){
                   var html = createNode(nodes[i]);
                   console.log(html);
                   $("#navTree").append(html);
                }

                
            }
        })
    }
}(jQuery));