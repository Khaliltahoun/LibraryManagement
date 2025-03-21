# 📚 Library Management System

Un projet de **gestion de bibliothèque** développé en **Java EE (Jakarta EE)** avec **JPA (EclipseLink), Servlets, JSP et Gson**.  
L'application permet de **gérer des utilisateurs, des documents (livres et magazines) et des emprunts**, avec une **sortie JSON uniquement**.

---

## 🚀 Technologies Utilisées
- **Java EE (Jakarta EE 10)**
- **JPA (EclipseLink)**
- **Servlets & JSP**
- **Tomcat 11**
- **MySQL**
- **Gson (pour la conversion JSON)**
- **Maven**

---

## 🛠 Installation & Configuration

### 1️⃣ Cloner le projet
```sh
git clone https://github.com/Khaliltahoun/LibraryManagement
cd library-management
```

### 2️⃣ Configurer MySQL

Créer une base de données library_db :

```sql
CREATE DATABASE library_db;
```

Modifier le fichier persistence.xml :

```xml
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="your_password"/>
```

### 3️⃣ Compiler et Déployer

```sh
mvn clean package
cp target/LibraryManagement-1.0-SNAPSHOT.war your_path/apache-tomcat-11.0.3/webapps/
```

### 4️⃣ Démarrer Tomcat

```sh
your_path/apache-tomcat-11.0.3/bin
./startup.sh

```

---

# 📡 Endpoints de l'API (CRUD)

## 📡 Endpoints de l'API (CRUD)
L'API REST renvoie des **réponses en JSON**.

---

### 🟢 1. Gérer les Utilisateurs
| Méthode | Endpoint      | Description                   |
|---------|-------------|-------------------------------|
| **GET** | `/users`    | Récupérer la liste des utilisateurs |
| **POST** | `/users`    | Ajouter un utilisateur |

📌 **Exemple - Ajouter un utilisateur**


<img width="1027" alt="Screenshot 2025-03-21 at 18 44 51" src="https://github.com/user-attachments/assets/5820ebc8-d1e1-4a7e-b8d4-c8a965148005" />


📌 **Récupérer la liste des utilisateurs**

<img width="1027" alt="Screenshot 2025-03-21 at 18 45 06" src="https://github.com/user-attachments/assets/b66bd56f-9125-48f7-b876-7caf0669b46a" />

### 🟢 2. Gérer les Documents (Livres & Magazines)
| Méthode | Endpoint      | Description                   |
|---------|-------------|-------------------------------|
| **GET** | `/documents`    | Récupérer la liste des documents |
| **POST** | `/documents/book`    | Ajouter un livre |
| **POST** | `/documents/magazine`    | Ajouter un magazine |

📌 **Exemple - Ajouter un document**

<img width="1028" alt="Screenshot 2025-03-21 at 18 45 16" src="https://github.com/user-attachments/assets/48393397-d2fc-4dc0-a5d6-37a5086caee2" />

<img width="1031" alt="Screenshot 2025-03-21 at 18 45 47" src="https://github.com/user-attachments/assets/e9845c45-44b9-49ef-b72c-5050175ea0f4" />


📌 **Récupérer la liste des documents**

<img width="1039" alt="Screenshot 2025-03-21 at 18 46 17" src="https://github.com/user-attachments/assets/c8263dcf-c83e-4312-bbf5-df839531eeaa" />

### 🟢 3. Gérer les Empprunts 
| Méthode | Endpoint      | Description                   |
|---------|-------------|-------------------------------|
| **GET** | `/borrows`    | Récupérer les emprunts en cours |
| **POST** | `/borrows`    | Emprunter un document |
| **DELETE** | `/borrows/{id}`    | Supprimer un emprunt |

📌 **Exemple - Ajouter un emprunt**

<img width="1035" alt="Screenshot 2025-03-21 at 18 46 27" src="https://github.com/user-attachments/assets/dc07c4ea-18b3-4c89-8a1f-f4e7ac01b99e" />


📌 **Récupérer la liste des emprunts**

<img width="1037" alt="Screenshot 2025-03-21 at 18 46 36" src="https://github.com/user-attachments/assets/92bdeb01-1075-48ed-8272-1d262a0bc3bb" />


📌 **Retourner un emprunt**

<img width="1023" alt="Screenshot 2025-03-21 at 18 46 43" src="https://github.com/user-attachments/assets/7649ac40-94d7-4aea-a1b8-ec5d7d7ff965" />






