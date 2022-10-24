import Axios from "../config"

let getIdFromToken = (credential) =>{
    return  Axios.post('/Account/getId', credential)
}

let getFullnameFromToken = (credential) =>{
    return  Axios.post('/Account/getFullname', credential)
}

let setFollow = (credential) =>{
    return Axios.post('Account/addRelation', credential)
}

export const GetFullnameService = {
    getIdFromToken,
    getFullnameFromToken,
    setFollow,
}