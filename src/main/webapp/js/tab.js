function settab(name,cur,n)
{
    for(i=1;i<=n;i++)
	{
	var menu=document.getElementById(name+i);
	var con=document.getElementById("con_"+name+"_"+i);
	con.style.display=(i==cur)?"block":"none";
	menu.className=(i==cur)?"hover":""
	}
}

function settab(name,one,n)
{
    for(i=1;i<=n;i++)
	{
	var menu=document.getElementById(name+i);
	var con=document.getElementById("con_"+name+"_"+i);
	con.style.display=(i==one)?"block":"none";
	menu.className=(i==one)?"hover":""
	}
}
