package com.example.Consultorio.repository;

import com.example.Consultorio.dao.UsuariosDAO;
import com.example.Consultorio.entities.Roles;
import com.example.Consultorio.entities.personas.Usuarios;
import com.example.Consultorio.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuariosRepoImpl implements UsuariosRepo {

    @Override
    public List<Usuarios> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuarios> usuarios = session.createNativeQuery("SELECT * FROM usuarios", Usuarios.class).list();
        session.close();
        return usuarios;
    }

    @Override
    public Usuarios findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        NativeQuery<Usuarios> query = session.createNativeQuery("SELECT * FROM usuarios u WHERE u.usuario = : username",Usuarios.class);
        query.setParameter("username",username);
        Usuarios usuario = query.getSingleResult();
        session.close();
        return usuario;
    }

    /* asersiones especificas

        List<UsuariosDAO> usuariosDAOS=new ArrayList<>();

        List<Object[]> objects = session.createNativeQuery("SELECT id, nombre FROM usuarios",Object[].class).list();

        for(Object[] object: objects){
            usuariosDAOS.add(new UsuariosDAO(
                    ((Long) object[0]),
                    (String)object[1]));
        }*/
}
