-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  mar. 22 mai 2018 à 23:25
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gogonight`
--

-- --------------------------------------------------------

--
-- Structure de la table `alimentation`
--

CREATE TABLE `alimentation` (
  `idAlimentation` int(11) NOT NULL,
  `TypeAlimentation` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `alimentation`
--

INSERT INTO `alimentation` (`idAlimentation`, `TypeAlimentation`) VALUES
(1, 'Thai'),
(2, 'turque'),
(3, 'libanais'),
(4, 'hallal'),
(5, 'gastronomie francaise'),
(6, 'Vietnamien'),
(7, 'chinois'),
(8, 'hindous'),
(9, 'vegetarien'),
(10, 'italien'),
(11, 'Sans gluten');

-- --------------------------------------------------------

--
-- Structure de la table `amis`
--

CREATE TABLE `amis` (
  `idAmiAssoc` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `idAmi` int(11) NOT NULL,
  `etatEnvoi` int(11) NOT NULL,
  `notiVue` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `invite`
--

CREATE TABLE `invite` (
  `idInvite` int(11) NOT NULL,
  `idOrganisateur` int(11) NOT NULL,
  `idAmi` int(11) NOT NULL,
  `idSoiree` int(11) NOT NULL,
  `etatEnvoi` int(11) NOT NULL,
  `notiVue` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

CREATE TABLE `lieu` (
  `idLieu` int(11) NOT NULL,
  `nom` varchar(1000) NOT NULL,
  `adresse` varchar(1500) NOT NULL,
  `placeId` varchar(5000) NOT NULL,
  `rating` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `soiree`
--

CREATE TABLE `soiree` (
  `idSoiree` int(11) NOT NULL,
  `idOrganisateur` int(11) NOT NULL,
  `idLieu` int(11) NOT NULL,
  `date` varchar(1000) NOT NULL,
  `dHeure` varchar(100) NOT NULL,
  `fHeure` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `useralim`
--

CREATE TABLE `useralim` (
  `idUserAlim` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `idPrefAlim` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `useralim`
--

INSERT INTO `useralim` (`idUserAlim`, `idUtilisateur`, `idPrefAlim`) VALUES
(48, 12, 2),
(49, 12, 3),
(50, 12, 7),
(51, 12, 9);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Age` int(11) NOT NULL,
  `Adresse` varchar(2500) NOT NULL,
  `DateNaiss` varchar(30) NOT NULL,
  `Phone` int(11) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `MoyTrans` varchar(20) NOT NULL,
  `Budget` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `Nom`, `Prenom`, `Age`, `Adresse`, `DateNaiss`, `Phone`, `Email`, `Password`, `Sex`, `MoyTrans`, `Budget`) VALUES
(12, 'toursal', 'thileli', 21, '34 rue victor basch,91300 Massy', '1997-01-05', 769409173, 'thileli@gmail.com', '781e5e245d69b566979b86e28d23f2c7', 'femme', 'train', 200);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `alimentation`
--
ALTER TABLE `alimentation`
  ADD PRIMARY KEY (`idAlimentation`);

--
-- Index pour la table `amis`
--
ALTER TABLE `amis`
  ADD PRIMARY KEY (`idAmiAssoc`);

--
-- Index pour la table `invite`
--
ALTER TABLE `invite`
  ADD PRIMARY KEY (`idInvite`);

--
-- Index pour la table `lieu`
--
ALTER TABLE `lieu`
  ADD PRIMARY KEY (`idLieu`);

--
-- Index pour la table `soiree`
--
ALTER TABLE `soiree`
  ADD PRIMARY KEY (`idSoiree`);

--
-- Index pour la table `useralim`
--
ALTER TABLE `useralim`
  ADD PRIMARY KEY (`idUserAlim`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `alimentation`
--
ALTER TABLE `alimentation`
  MODIFY `idAlimentation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `amis`
--
ALTER TABLE `amis`
  MODIFY `idAmiAssoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `invite`
--
ALTER TABLE `invite`
  MODIFY `idInvite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `lieu`
--
ALTER TABLE `lieu`
  MODIFY `idLieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `soiree`
--
ALTER TABLE `soiree`
  MODIFY `idSoiree` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `useralim`
--
ALTER TABLE `useralim`
  MODIFY `idUserAlim` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
