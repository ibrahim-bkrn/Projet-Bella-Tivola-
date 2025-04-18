#PROJET JAVA BELLA TIVOLA
## Système de Gestion de Restaurant

Une application Java pour gérer efficacement les opérations d’un restaurant : gestion des commandes, du menu, du stock d’ingrédients et du personnel, avec persistance des données dans une base MySQL.

---

## Sommaire

- À propos
- Organisation du code
- Choix techniques
- Fonctionnalités
- Prérequis
- Installation
- Tests
- Axes d’amélioration
- Contact

---

## À propos

Ce projet vise à automatiser et fiabiliser le suivi des plats, des stocks et des employés dans un restaurant, tout en offrant une interface console intuitive et interactive. Il permet de centraliser la gestion du menu, des commandes, du stock d’ingrédients et du personnel.

---

## Organisation du code

L’application repose sur une architecture modulaire et orientée objet :

- **Plat** : Représente un plat du menu.
- **Commande** : Gère les commandes clients.
- **Stock** : Gère les ingrédients et leurs quantités.
- **Employee** : Classe abstraite pour les employés, déclinée en `Serveur`, `Cuisinier` et `Gerant`.
- **Menu** : Centralise les plats disponibles.
- **database** : Encapsule toutes les opérations SQL (insertion, suppression, mise à jour, lecture) via JDBC.
- **Main** : Propose une interface console interactive pour l’utilisateur.

---

## Choix techniques

- **Héritage et polymorphisme** : Utilisés pour modéliser les différents rôles d’employés, facilitant l’ajout de nouveaux types de personnel et la centralisation des comportements communs.
- **Collections Java** : Utilisation de listes dynamiques (`ArrayList`) pour gérer les collections de plats, d’ingrédients ou de commandes, garantissant une manipulation souple et typée des données.
- **Gestion des exceptions** : Toutes les opérations susceptibles d’échouer (notamment avec la base de données) sont encapsulées dans des blocs `try/catch`, avec affichage d’un message d’erreur explicite pour faciliter le débogage et éviter les plantages.
- **Persistance** : Le choix de JDBC pour la connexion à MySQL permet un contrôle précis sur les requêtes et la structure de la base. Les méthodes de la classe `database` assurent la cohérence entre la mémoire et la base de données.

---

## Fonctionnalités

✅ Ajout, modification et suppression de plats, commandes, ingrédients et employés  
✅ Vérification automatique du stock lors de la prise de commande  
✅ Mise à jour du stock après chaque commande validée  
✅ Interface console interactive avec menus clairs et emojis  
✅ Gestion des erreurs SQL et retours explicites à l’utilisateur  
✅ Historique des commandes et consultation du stock en temps réel  

---

## Prérequis

- Java JDK 23 ou supérieur
- MySQL 8 ou supérieur
- MySQL Connector/J (JAR)
- Git (optionnel)

---

## Installation

**1. Cloner le projet :**
git clone https://github.com/ibrahim-bkrn/Projet-Bella-Tivola-/blob/main/src.zip
cd gestion-restaurant

text

**2. Configurer la base de données :**
- Créez la base et les tables nécessaires dans MySQL :
CREATE DATABASE bellaTivola;
USE bellaTivola;
CREATE TABLE plats (nom VARCHAR(50), prix DECIMAL, type VARCHAR(20));
CREATE TABLE stocks (nom VARCHAR(50), quantite INT);
CREATE TABLE employes (nom VARCHAR(50), role VARCHAR(20));
CREATE TABLE commande (id INT, total DECIMAL);



**3. Configurer l’accès à la base de données :**
- Ouvrez `database.java` et adaptez les variables :
private static String url = "jdbc:mysql://localhost:3306/bellaTivola";
private static String user = "root";
private static String password = "votre_mot_de_passe";


**4. Compiler et exécuter l’application :**
javac -cp .:mysql-connector-j-9.3.0.jar Main.java
java -cp .:mysql-connector-j-9.3.0.jar Main


---

## Tests

Des tests ont été réalisés pour valider les fonctionnalités principales :

- Ajout d’un ingrédient au stock
- Création d’un plat avec plusieurs ingrédients
- Ajout de plats au menu
- Création de commandes et vérification de la disponibilité des ingrédients
- Mise à jour automatique du stock après validation d’une commande
- Persistance des données dans la base MySQL
- Gestion des stocks insuffisants, suppression d’ingrédients ou de plats, gestion des erreurs de connexion ou de requête SQL

Les tests ont été menés via des classes dédiées (`test.java`, `Test2.java`) et via l’interface utilisateur principale.

---

## Axes d’amélioration

- **Sécurisation des accès à la base de données** (externalisation des identifiants de connexion)
- **Optimisation des requêtes SQL** (notamment pour la gestion des ingrédients associés aux plats)
- **Mise en place de tests unitaires automatisés** pour renforcer la robustesse du projet
- **Possibilité de migration vers une interface graphique** pour une meilleure expérience utilisateur

---

## Contact

Auteurs : Ibrahim BOUKERNAFA ; Mory TOURE ; DHOUIB Hager

Email : ibrahim.boukernafa@efrei.net ; mory.toure@efrei.net ; hager.dhouibhager@yahoo.com 

GitHub : https://github.com/ibrahim-bkrn/Projet-Bella-Tivola-/blob/main/src.zip
