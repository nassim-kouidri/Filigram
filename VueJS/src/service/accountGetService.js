import axios from "axios"

const POST_API_BASE_URL = "http://localhost:8081/api/Account/" + localStorage.Id;

const POST_API_BASE_URL_Found = "http://localhost:8081/api/Account/";

class AccountGetService {
    getAccount() {
        return axios.get(POST_API_BASE_URL);
    }
    getAccountFound(id) {
        return axios.get(POST_API_BASE_URL_Found + id);
    }
    putAccount() {
        return axios.put(POST_API_BASE_URL);
    }
}

export default new AccountGetService()