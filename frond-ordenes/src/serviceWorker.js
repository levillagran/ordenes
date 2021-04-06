import axios from 'axios'

const CLIENTES_LISTAR_URL = 'http://localhost:8087/cliente/listar';
const CLIENTES_GUARDAR_URL = 'http://localhost:8087/cliente/guardar';
const CLIENTES_ACTUALIZAR_URL = 'http://localhost:8087/cliente/actualizar';
const CLIENTES_ELIMINAR_URL = 'http://localhost:8087/cliente/eliminar';
const CLIENTES_OBTENER_URL = 'http://localhost:8087/cliente/obtener';
const ARTICULO_LISTAR_URL = 'http://localhost:8087/articulo/listar';
const ARTICULO_GUARDAR_URL = 'http://localhost:8087/articulo/guardar';
const ARTICULO_ACTUALIZAR_URL = 'http://localhost:8087/articulo/actualizar';
const ARTICULO_ELIMINAR_URL = 'http://localhost:8087/articulo/eliminar';
const ARTICULO_OBTENER_URL = 'http://localhost:8087/articulo/obtener';
const ORDEN_LISTAR_URL = 'http://localhost:8087/orden/listar';
const ORDEN_GUARDAR_URL = 'http://localhost:8087/orden/guardar';
const ORDEN_ACTUALIZARI_URL = 'http://localhost:8087/orden/actualizar';
const ORDEN_ELIMINAR_URL = 'http://localhost:8087/orden/eliminar';
const ORDEN_OBTENER_URL = 'http://localhost:8087/orden/obtener';
const ORDEN_DETALLE_LISTAR_URL = 'http://localhost:8087/ordenDetalle/listar';


class ClienteService {

    getClientes(){
        return axios.get(CLIENTES_LISTAR_URL);
    }

    getOrdenes(){
        return axios.get(ORDEN_LISTAR_URL);
    }

    getOrdenesDetalle(){
        return axios.get(ORDEN_DETALLE_LISTAR_URL);
    }
}

export default new ClienteService();