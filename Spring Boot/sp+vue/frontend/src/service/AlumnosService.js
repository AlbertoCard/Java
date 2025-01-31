import axios from 'axios';

const ALUMNOS_API_BASE_URL = "http://localhost:8081/alumnos/listarAlumnos";

class AlumnosService {

    getAlumnos(){
        return axios.get(ALUMNOS_API_BASE_URL);
    }
}

export default new AlumnosService();