/**
*
* Assume we are fetching the data from a rest endpoint in the get data function.
* we can simulate the same by replacing the setTimeout with fetch api and executing the same in a browser.
* How do you solve this problem. How can we wait for till the function execution is completed,
  so that we can have correct email?
*
*/

// using Promises
function getData(uId) {
    return new Promise((resolve, reject) => {
        if (uId) {
            setTimeout(() => {
                console.log("Fetched the data!");
                resolve(uId + "@gmail.com");
            }, 4000);
        }
        else
            reject("Failed to Fetch!!!");
    });
}

console.log("start");
getData("lahari").then((res) => {
    console.log("Email id of the user id is: "+ res);
}).catch((err) => {
    console.log(err);
}).finally(() => {
    console.log("end");
})

// using Async and Await
function getData(uId) {
    return new Promise((resolve, reject) => {
        if (uId) {
            setTimeout(() => {
                console.log("Fetched the data!");
                resolve(uId + "@gmail.com");
            }, 4000);
        }
        else
            reject("Failed to Fetch!!!");
    });
}
async function fetch() {
    console.log("start");
    try {
        const promise = await getData("vinay");
        console.log("Email id of the user id is: "+ promise);
    } catch (err) {
        console.log(err);
    } finally{
        console.log("end");
    }
}
fetch();