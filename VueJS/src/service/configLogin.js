import axios from 'axios';
//import router from '../router/index';

const Axios = axios.create({
    baseURL: 'http://localhost:8081/api/public',
});

 Axios.interceptors.response.use(response =>{
     return response
 }, error => {
     console.log(error.response.status)
     if(error.response.status == 401){
         localStorage.removeItem('jwtToken')
        // router.push('/')
        //header("Location:  http://localhost:3000);
        window.location = "http://localhost:3000";
        
     }
 })

export default Axios;
