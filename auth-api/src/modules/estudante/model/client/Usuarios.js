import axios from "axios";

import { USUARIOS_API_URL } from "../../../../config/constants/secrets.js";

class DadosUsuarios {
  async getDataUser(id_usuario, token) {
    try {
      let response = false;
      console.log(id_usuario);

      const headers = {
        Authorization: token,
      };

      await axios
        .get(`${USUARIOS_API_URL}/${id_usuario}`, { headers })
        .then((res) => {
          console.log(res.data);
          response = res.data;
        })
        .catch((res) => {
          response = false;
        });
      return response;
    } catch (err) {
      console.error(err);
      return false;
    }
  }
}

export default new DadosUsuarios();
