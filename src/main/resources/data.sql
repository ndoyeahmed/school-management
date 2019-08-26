BEGIN;
INSERT IGNORE INTO profil (`id`, `nom`, `description`,`etat`,`is_archiver`) VALUES
(1, 'Super Administrateur', 'Super Administrateur general de la plateforme',true ,false ),
(2, 'Administrateur', 'Administrateur établissement',true ,false );
COMMIT;
