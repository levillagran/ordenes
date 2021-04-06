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
            clientes:[],
            ordenDetalle:[],
            modalActualizar: false,
            modalInsertar: false,
            modalOrdenes: false,
            form: {
            clienteId: "",
            nombre: "",
            apellido: "",
            },    
            formOrden: [{
                orden_detalle_id: "",
                orden: {
                    orden_id: "",
                    fecha: "",
                    cliente: {
                        nombre: "",
                        apellido: "",
                        clienteId: ""
                    }
                },
                articulo: {
                    articulo_id: "",
                    codigo: "",
                    nombre: "",
                    precio_unitario: ""
                }
            }],    
        }
    }

    mostrarModalOrdenes = (clienteId) => {
        this.setState({
        formOrden: this.state.ordenDetalle,
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

    componentDidMount(){
        ClienteService.getClientes().then((response) => {
            this.setState({ clientes: response.data})
        });

        ClienteService.getOrdenesDetalle().then((response) => {
            this.setState({ ordenDetalle: response.data})
        });
    }

    render (){
        return (
                
        <>    
            <Container>
            <br />
            <h1 className = "text-center"> Lista clientes</h1>
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
                            onClick={() => this.mostrarModalOrdenes()}
                            >Ordenes</Button></td>
                        <td>
                            <Button
                            color="primary"
                            onClick={() => this.mostrarModalActualizar(cliente)}
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
                    {this.state.ordenDetalle.map(
                        orden => 
                        <tr key = {orden.orden_detalle_id}>
                            <td> {orden.orden.fecha}</td>   
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
        </>
        )
    }
}

export default ClienteComponent