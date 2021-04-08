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

const ARTICULO_CONSUMO_STOCK_URL = 'http://localhost:8087/articulo/stock';


class  ClienteService {

    async getClientes(){
        return await axios.get(CLIENTES_LISTAR_URL);
    }

    async getOrdenes(){
        return await axios.get(ORDEN_LISTAR_URL);
    }

    async getOrdenesDetalle(){
        return await axios.get(ORDEN_DETALLE_LISTAR_URL);
    }

    async getArticulos(){
        return await axios.get(ARTICULO_LISTAR_URL);
    }

    async consumoStockArticulo(articuloId, cantidad){

        const data = {
            articuloId: articuloId,
            cantidad: cantidad
          }

        return await axios.post(ARTICULO_CONSUMO_STOCK_URL, data);
    }
    
}

export default new ClienteService();