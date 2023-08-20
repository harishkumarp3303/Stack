function observable(call){
    let arr=[]
    setTimeout(async () => {
        arr= await call(arr)
    },5000)
    return arr;
}



function call(arr){
    for (let i = 0; i < 5; i++) {
        arr.push(i)
        
    }
    return arr;
}


// await res=observable(call)
console.log(res)