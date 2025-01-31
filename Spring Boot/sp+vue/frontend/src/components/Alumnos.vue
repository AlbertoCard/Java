<template>
    <div class="container">
        <h1 class="text-container"></h1>
        <table class="table table-striped">
            <thead>
                <th>NControl</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Fecha de nacimiento</th>
                <th>Carrera</th>
            </thead>
            <tbody>
                <tr v-for='alumno in alumnos' v-bind:key="alumno.ncontrol">
                    <td>{{alumno.ncontrol}}</td>
                    <td>{{alumno.nombres}}</td>
                    <td>{{alumno.apellidos}}</td>
                    <td>{{alumno.fecha_nacimiento}}</td>
                    <td>{{alumno.carrera}}</td>
                </tr>
            </tbody>
        </table>
    </div>

</template>

<script>
import AlumnosService from '../service/AlumnosService'
    export default {
        name: 'AlumnosList',
        data() {
            return {
                alumnos: []
            }
        },
        methods: {
            getAlumnos() {
                AlumnosService.getAlumnos().then(response => {
                    this.alumnos = response.data
                }).catch(error => {
                    console.log(error)
                })
            }
        },
        created() {
            this.getAlumnos()
        }
    }
</script>