-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 17 avr. 2018 à 18:05
-- Version du serveur :  10.1.26-MariaDB
-- Version de PHP :  7.1.9

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
(1, 'Thaï'),
(2, 'turque'),
(3, 'libanais'),
(4, 'hallal'),
(5, 'gastronomie francaise'),
(6, 'Vietnamien'),
(7, 'chinois'),
(8, 'hindous'),
(9, 'végétarien'),
(10, 'italien'),
(11, 'Sans gluten');

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
(1, 2, 1),
(2, 2, 2),
(3, 2, 3);

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
(2, 'Chabane', 'Hichem', 23, 'Constantine', '1994-10-16', 123456789, 'hichem@gmail.com', '12345', 'homme', 'tramway', 300);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `alimentation`
--
ALTER TABLE `alimentation`
  ADD PRIMARY KEY (`idAlimentation`);

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
-- AUTO_INCREMENT pour la table `useralim`
--
ALTER TABLE `useralim`
  MODIFY `idUserAlim` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
