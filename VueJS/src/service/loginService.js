import Axios from "./configLogin"

let login = (credential) =>{
    return Axios.post('/login', credential)
}

export const LoginService = {
    login,
}
