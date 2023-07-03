        package org.will1184.repository;

        import org.will1184.entity.Actor;
        import org.will1184.entity.Director;
        import org.will1184.entity.Participa;

        import java.util.List;

        public interface BusquedaActorRepository {
            List<Actor> actorListDeadPorNacion(String nacion);
            List<Object[]> actorMayorParticipacion();


        }
