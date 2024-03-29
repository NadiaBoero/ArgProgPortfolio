package com.portfolioweb.portfolio.Seguridad.Servicio;

import com.portfolioweb.portfolio.Seguridad.Entidad.Usuario;
import com.portfolioweb.portfolio.Seguridad.Entidad.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionDetalleUsuario implements UserDetailsService {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String NombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.getByNombreUsuario(NombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
    
}
