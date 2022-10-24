import axios from "axios"

const ACCOUNT_API_BASE_URL = "http://localhost:8081/api/addAccount";



class AccountService {
    addAccount() {
        return axios.get(ACCOUNT_API_BASE_URL);
    }
}

export default new AccountService()