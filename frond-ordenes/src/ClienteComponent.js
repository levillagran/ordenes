import React, { Component } from 'react';
import ClienteService from './serviceWorker';
import "bootstrap/dist/css/bootstrap.min.css";

import {
    Table,
    Button,
    Container,
    Modal,
    ModalHeader,
    ModalBody,
    FormGroup,
    ModalFooter,
  } from "reactstrap";

class ClienteComponent extends Component {
   
    constructor(props){
        super(props)
        this.state = {
            cantidad:0,
            clientes:[],
            ordenDetalles:[],
            articulo:[],
            articulos:[],
            modalActualizar: false,
            modalInsertar: false,
            modalOrdenes: false,
            form: {
            clienteId: "",
            nombre: "",
            apellido: "",
            },    
            formOrden: [{
                ordenDetalleId: "",
                orden: {
                    ordenId: "",
                    fecha: "",
                    cliente: {
                        nombre: "",
                        apellido: "",
                        clienteId: ""
                    }
                },
                articulo: {
                    articuloId: "",
                    codigo: "",
                    nombre: "",
                    precioUnitario: "",
                    stock: "",
                }
            }],
            formArticulo: [{
                articuloId: "",
                codigo: "",
                nombre: "",
                precioUnitario: "",
                stock: "",
            }],  
        }
    }

    mostrarModalOrdenes = (ordenDetalles) => {
        this.setState({ 
            ordenDetalles: ordenDetalles,
          modalOrdenes: true,
        });
      };

    cerrarModalOrdenes = () => {
        this.setState({ modalOrdenes: false });
      };

    mostrarModalActualizar = (cliente) => {
        this.setState({
          form: cliente,
          modalActualizar: true,
        });
      };

    cerrarModalActualizar = () => {
        this.setState({ modalActualizar: false });
      };

    mostrarModalInsertar = () => {
    this.setState({
        modalInsertar: true,
    });
    };

    cerrarModalInsertar = () => {
    this.setState({ modalInsertar: false });
    };

    mostrarModalArticuloStock = (articulo) => {
        this.cerrarModalArticulo()
        this.setState({
          formArticulo: articulo,
          modalArticuloStock: true,
        });
      };

    cerrarModalArticuloStock = () => {
        this.setState({ modalArticuloStock: false });
    };

    mostrarModalArticulo = (articulos) => {
        this.setState({
          articulos: articulos,
          modalArticulo: true,
        });
      };

    cerrarModalArticulo = () => {
        this.setState({ modalArticulo: false });
    };

    consumoStock = (articuloId) => {
        ClienteService.consumoStockArticulo(articuloId, this.state.cantidad).then((response) => {
            this.setState({ articulo: response.data})
        });
        this.setState({ modalArticuloStock: false });
        ClienteService.getArticulos().then((response) => {
            this.setState({ articulos: response.data,modalArticulo: true})
        });
    };

    componentDidMount(){
        ClienteService.getClientes().then((response) => {
            this.setState({ clientes: response.data})
        });

        ClienteService.getOrdenesDetalle().then((response) => {
            this.setState({ ordenDetalles: response.data})
        });

        ClienteService.getArticulos().then((response) => {
            this.setState({ articulos: response.data})
        });
    }

    handleChangeUno = (e) => {
        this.setState({
          cantidad: e.target.value,
        });
      };

    render (){
        return (
                
        <>    
            <Container>
            <br />
            <h1 className = "text-center"> Lista clientes</h1>
            <Button color="warning" onClick={()=>this.mostrarModalArticulo(this.state.articulos)}>Inventario articulos</Button>{" "}
              <Button color="success" onClick={()=>this.mostrarModalInsertar()}>Crear cliente</Button>
              <br />
              <br />
              <table class="table table-striped">
                <thead>
                  <tr>
                    <td> Nombre</td>
                    <td> Apellido</td>
                    <td> Ordenes</td>
                    <td> Acciones cliente</td>
                  </tr>
                </thead>
    
                <tbody>
                  {this.state.clientes.map(
                    cliente => 
                    <tr key = {cliente.clienteId}>
                        <td> {cliente.nombre}</td>   
                        <td> {cliente.apellido}</td>
                        <td>
                            <Button 
                            color="warning" 
                            onClick={() => this.mostrarModalOrdenes(this.state.ordenDetalles)}
                            >Ordenes</Button></td>
                        <td>
                            <Button
                            color="primary"
                            onClick={() => this.mostrarModalActualizar(cliente,this.state.clientes)}
                            >Editar</Button>{" "}
                            <Button color="danger" >Eliminar</Button>
                        </td>
                    </tr>
                  )}
                </tbody>
              </table>
            </Container>

            <Modal isOpen={this.state.modalActualizar}>
                <ModalHeader>
                <div><h3>Editar cliente</h3></div>
                </ModalHeader>

                <ModalBody>
                    <FormGroup>
                    <label>
                    Id:
                    </label>
                    
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.form.clienteId}
                    />
                    </FormGroup>
                    
                    <FormGroup>
                    <label>
                        Nombre: 
                    </label>
                    <input
                        className="form-control"
                        name="cliente"
                        type="text"
                        onChange={this.handleChange}
                        value={this.state.form.nombre}
                    />
                    </FormGroup>
                    
                    <FormGroup>
                    <label>
                        Apellido: 
                    </label>
                    <input
                        className="form-control"
                        name="apellido"
                        type="text"
                        onChange={this.handleChange}
                        value={this.state.form.apellido}
                    />
                    </FormGroup>
                </ModalBody>

                <ModalFooter>
                    <Button
                    color="primary"
                    
                    >
                    Editar
                    </Button>
                    <Button
                    color="danger"
                    onClick={() => this.cerrarModalActualizar()}
                    >
                    Cancelar
                    </Button>
                </ModalFooter>
            </Modal>

            <Modal isOpen={this.state.modalInsertar}>
                <ModalHeader>
                <div><h3>Insertar Cliente</h3></div>
                </ModalHeader>

                <ModalBody>
                    <FormGroup>
                    <label>
                        Id: 
                    </label>
                    
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.clientes.length+1}
                    />
                    </FormGroup>
                    
                    <FormGroup>
                    <label>
                        Nombre: 
                    </label>
                    <input
                        className="form-control"
                        name="nombre"
                        type="text"
                        onChange={this.handleChange}
                    />
                    </FormGroup>
                    
                    <FormGroup>
                    <label>
                        Apellido: 
                    </label>
                    <input
                        className="form-control"
                        name="apellido"
                        type="text"
                        onChange={this.handleChange}
                    />
                    </FormGroup>
                </ModalBody>

                <ModalFooter>
                    <Button
                    color="primary"
                    
                    >
                    Insertar
                    </Button>
                    <Button
                    className="btn btn-danger"
                    onClick={() => this.cerrarModalInsertar()}
                    >
                    Cancelar
                    </Button>
                </ModalFooter>
            </Modal>    

            <Modal isOpen={this.state.modalOrdenes}>
                <ModalHeader>
                <div><h3>Lista ordenes</h3></div>
                </ModalHeader>

                <ModalBody>
                <Table>
                    <thead>
                    <tr>
                        <td> fecha</td>
                        <td> cliente</td>
                        <td> articulo</td>
                        <td> precio</td>
                        <td> Acciones</td>
                    </tr>
                    </thead>
        
                    <tbody>
                    {this.state.ordenDetalles.map(
                        orden => 
                        <tr key = {orden.orden_detalle_id}>
                            <td> {orden.orden.fecha}</td>   
                            <td> {orden.orden.cliente.nombre}</td>   
                            <td> {orden.articulo.nombre}</td>
                            <td> {orden.articulo.precio_unitario}</td>
                            <td>
                                <Button
                                color="primary"
                                >Editar</Button>{" "}
                                <Button color="danger" >Eliminar</Button>
                            </td>
                        </tr>
                    )}
                    </tbody>
                </Table>
                </ModalBody>

                <ModalFooter>
                    <Button
                    color="primary"
                    >
                    Nueva Orden
                    </Button>
                    <Button
                    className="btn btn-danger"
                    onClick={() => this.cerrarModalOrdenes()}
                    >
                    Cancelar
                    </Button>
                </ModalFooter>
            </Modal> 

            <Modal isOpen={this.state.modalArticuloStock}>
                <ModalHeader>
                <div><h3>Consumo en Stock de articulo</h3></div>
                </ModalHeader>

                <ModalBody>
                    <FormGroup>
                    <label>
                    Id:
                    </label>
                    
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.formArticulo.articulo_id}
                    />
                    </FormGroup>
                    
                    <FormGroup>
                    <label>
                        Codigo: 
                    </label>
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.formArticulo.codigo}
                    />
                    </FormGroup>
                    
                    <FormGroup>
                    <label>
                        Nombre: 
                    </label>
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.formArticulo.nombre}
                    />
                    </FormGroup>
                    <FormGroup>
                    <label>
                        Precio: 
                    </label>
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.formArticulo.precio_unitario}
                    />
                    </FormGroup>
                    <FormGroup>
                    <label>
                        Stock: 
                    </label>
                    <input
                        className="form-control"
                        readOnly
                        type="text"
                        value={this.state.formArticulo.stock}
                    />
                    </FormGroup>
                    <FormGroup>
                        <label>
                            Cantidad a descontar: 
                        </label>
                        <input
                            className="form-control"
                            name="cantidad"
                            type="number"
                            onChange={this.handleChangeUno}
                        />
                        </FormGroup>
                </ModalBody>

                <ModalFooter>
                    <Button
                    color="primary"
                    onClick={() => this.consumoStock(this.state.formArticulo.articulo_id)}
                    >
                    Consumir
                    </Button>
                    <Button
                    color="danger"
                    onClick={() => this.cerrarModalArticuloStock()}
                    >
                    Cancelar
                    </Button>
                </ModalFooter>
            </Modal>

            <Modal isOpen={this.state.modalArticulo}>
                <ModalHeader>
                <div><h3>Articulos</h3></div>
                </ModalHeader>

                <ModalBody>
                    <Container>
                    <br />
                    <Button color="success" >Agregar articulo</Button>
                    <br />
                    <br />
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <td> Codigo</td>
                            <td> Nombre</td>
                            <td> Precio Unitario</td>
                            <td> Stock</td>
                        </tr>
                        </thead>
            
                        <tbody>
                        {this.state.articulos.map(
                            articulo => 
                            <tr key = {articulo.articulo_id}>
                                <td> {articulo.codigo}</td>   
                                <td> {articulo.nombre}</td>
                                <td> {articulo.precio_unitario}</td>
                                <td> {articulo.stock}</td>
                                <td>
                                    <Button
                                    color="primary"
                                    onClick={() => this.mostrarModalArticuloStock(articulo)}
                                    >Consumir</Button>{" "}
                                    <Button color="danger" >Eliminar</Button>
                                </td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                    </Container>
                </ModalBody>

                <ModalFooter>
                    <Button
                    color="danger"
                    onClick={() => this.cerrarModalArticulo()}
                    >
                    Cancelar
                    </Button>
                </ModalFooter>
            </Modal>

        </>
        )
    }
}

export default ClienteComponent