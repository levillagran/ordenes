import React from 'react';
import ClienteService from './serviceWorker';

class ClienteComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            clientes:[]
        }
    }

    componentDidMount(){
        ClienteService.getClientes().then((response) => {
            this.setState({ clientes: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> Lista clientes</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> nombre</td>
                            <td> apellido</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.clientes.map(
                                cliente => 
                                <tr key = {cliente.clienteId}>
                                     <td> {cliente.nombre}</td>   
                                     <td> {cliente.apellido}</td>    
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}

export default ClienteComponent