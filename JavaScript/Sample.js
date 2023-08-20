function add(a){
 
    return function innerfuntion(b){
        return function innermostfuntion(c){
            return a+b+c
        }
    
    }

     
}

let x=add(20)


console.log(x(20)(20))

  