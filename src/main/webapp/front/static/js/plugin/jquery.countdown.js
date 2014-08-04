UI.extend.countdown = function(option){
    var opt = {
        format : "dd:hh:mm:ss",   // 时间格式 自定义倒计时类型 现支持 dd:hh:mm:ss(默认) hh:mm:ss dd:hh:mm mm:ss 四种格式
        prezero : true,  // 前导零
        effect : false,  // 支持自定义格式
        overtips : "已结束",  // 自定义结束提醒
        timeauto : false,   // 默认不自适应格式
        daytips : false,
        timeday : 15,
        timediff : 0,   // 调整时间差，单位毫秒
		newload : false
    }
    opt = $.extend(true, opt, option || {});
    function timeOver(obj,all){
        var time = parseInt(all/1000);
        
        var s = time%60;
        time = parseInt(time/60);
        var m = time%60;
        time = parseInt(time/60);
        var h = parseInt(time%24);
        var day = parseInt(time/24);
        
        if(opt.daytips && day>opt.timeday-1){
            obj.innerHTML = opt.timeday+ '天以上';
            return;
        }
        
        var times = 1000;
        var labelleft = "";
        var labelright = "";
        if(opt.effect){
            labelleft = "<i>";
            labelright = "</i>";
        }
        if(opt.prezero){
            m = (m < 10) ? ("0" + m) : m;
            h = (h < 10) ? ("0" + h) : h;
            s = (s < 10) ? ("0" + s) : s;
        }
        if(opt.timeauto){
            if(all < 86400000){
                opt.format = "hh:mm:ss";
                if(all < 3600000){
                    opt.format = "mm:ss";
                    if(all < 60000){
                        opt.format = "ss";
                    }
                }
            }
        }
        switch(opt.format){
            case "dd:hh:mm:ss":
                times = 1000;
                obj.innerHTML = labelleft + day + labelright + "天" + labelleft + h + labelright + "时" 
                                + labelleft + m + labelright + "分" + labelleft + s + labelright + "秒" ;
                break;
            case "hh:mm:ss":
                times = 1000;
                obj.innerHTML = labelleft + h + labelright + "时" + labelleft + m + labelright + "分" 
                                + labelleft + s + labelright + "秒" ;
                break;
            case "mm:ss":
                times = 1000;
                obj.innerHTML = labelleft + m + labelright + "分" + labelleft + s + labelright + "秒" ;
                break;
            case "ss":
                times = 1000;
                obj.innerHTML = labelleft + s + labelright + "秒" ;
                break;
            case "dd:hh:mm":
                times = 60000;
                obj.innerHTML = labelleft + day + labelright + "天" + labelleft + h + labelright + "时" 
                                + labelleft + m + labelright + "分" ;
                break;
            default :
                times = 1000;
                obj.innerHTML = day+"天"+h+"时"+m+"分"+s+"秒";
        }
        setTimeout(function(){
            all-=times;
            if(all>0){
                timeOver(obj,all);
            }else {
				obj.innerHTML = opt.overtips;
				if(opt.newload==true && oldTime > 0){
					window.location.reload();
				}
            }
        },times);
    }
    
    var all;
    if($(this).attr('data-time')){
        all = $(this).attr('data-time');
    }else{
        all = $(this).html();
    }
    
    // 若为非数字，直接返回
    if(!(/(^-?[1-9]\d*$)/.test(all))){
        this.innerHTML = all;
        return;
    }
    
    if(parseInt(all) < 0){
        this.innerHTML = opt.overtips;
        return;
    }
    
    all = Number(all) + opt.timediff;
	var oldTime = all;
    timeOver(this,all);
}