var step=1;
function slideit(){
//if browser does not support the image object, exit.
if (!document.images)
return
document.images.slide.src=eval("image"+step+".src");
if (step<7)
step++;
else
step=1;
//call function "slideit()" every 2.5 seconds
setTimeout("slideit()",2500);
}
slideit();