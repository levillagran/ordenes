import axios from 'axios'

const CLIENTES_REST_API_URL = 'http://localhost:8087/cliente/listar';

class ClienteService {

    getClientes(){
        return axios.get(CLIENTES_REST_API_URL);
    }
}

export default new ClienteService();