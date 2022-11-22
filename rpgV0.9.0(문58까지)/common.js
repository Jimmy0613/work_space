function br(){
    str = str + "\n";
    t.value = str;
}

function dw(s){
    str = str + s;
    t.value = str;
}

function hr(){
    str = str + "\n===========================================================================\n";
    t.value = str;
}

function r(n){
    var random = Math.floor(Math.random()*n)+1;
    return random;
}