// function add(a){
 
//     return function innerfuntion(b){
//         return function innermostfuntion(c){
//             return a+b+c
//         }
    
//     }

     
// }

// let x=add(20)


// console.log(x(20)(20))

function x(x){
    return function (y){
        return function (z){
            return x+y+z
        }
    }
}

let a=x(1)
console.log(a)
let b=a(2)  
console.log(b)
let c=b(3)

console.log(c)