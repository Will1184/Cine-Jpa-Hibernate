package org.will1184.repository;

import org.will1184.entity.Director;

public interface BusquedaDirectorRepository {
    Director directorMayorParticipacion();
    Director directorParticipaciones(int participaciones);
    Director directorSinParticipaciones();
}
