package com.example.Consultorio.repository;

import com.example.Consultorio.entities.personas.Usuarios;
import com.example.Consultorio.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuariosDAOImpl implements UsuariosDAO{


    @Override
    public List<Usuarios> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Usuarios> usuarios = session.createNativeQuery("SELECT * FROM usuarios",Usuarios.class).list();

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
}
