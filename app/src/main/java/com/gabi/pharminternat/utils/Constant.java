package com.gabi.pharminternat.utils;

/**
 * Created by gabi on 15/07/16.
 */
public class Constant {
    public static final String DAO_QUERY_TEST_DB = "SELECT * FROM PharmaSection";

    public static final String DAO_QUERY_DROP_PHARMASECTION = "DROP TABLE IF EXISTS PharmaSection ";
    public static final String DAO_QUERY_DROP_PHARMAFILE = "DROP TABLE IF EXISTS PharmaFile";
    public static final String DAO_QUERY_CREATE_TABLE_PHARMAFILE = "CREATE TABLE PharmaFile(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "section INT NOT NULL," +
            "displayOrder REAL NOT NULL," +
            "fileTitle TEXT NOT NULL," +
            "reviewCounter INT NOT NULL DEFAULT 0," +
            "lastReview TEXT NOT NULL DEFAULT '2004-01-01 02:34:56')";
    public static final String DAO_QUERY_CREATE_TABLE_PHARMASECTION = "CREATE TABLE PharmaSection(section INT NOT NULL," +
            " sectionTitle TEXT NOT NULL)";
    public static final String DAO_QUERY_SELECT_PHARMAFILES = "SELECT * FROM PharmaFile WHERE section = ? ORDER BY datetime(lastReview) ASC, displayOrder ASC";
    public static final String DAO_QUERY_SELECT_PHARMASECTIONS = "SELECT * FROM PharmaSection";
    public static final String DAO_QUERY_SELECT_PHARMASECTION = "SELECT * FROM PharmaSection where section= ?";
    public static final String DAO_QUERY_UPDATE_REVIEW_COUNTER = "UPDATE PharmaFile SET reviewCounter = reviewCounter + 1 where id = ?";
    public static final String DAO_QUERY_UPDATE_LAST_REVIEW_DATE = "UPDATE PharmaFile SET lastReview = ? where id = ?";

    public static final String pharmaSectionSectionColumn = "section";
    public static final String pharmaSectionSectionTitleColumn = "sectionTitle";
    public static final String pharmaFileIdColumn = "id";
    public static final String pharmaFileSectionColumn = "section";
    public static final String pharmaFileDisplayOrderColumn = "displayOrder";
    public static final String pharmaFileFileTitleColumn = "fileTitle";
    public static final String pharmaFileReviewCounterColumn = "reviewCounter";
    public static final String pharmaFileLastReviewColumn = "lastReview";

    public static final String[] DAO_QUERY_INSERTS_PHARMASECTION = {
            "INSERT INTO PharmaSection(section, sectionTitle) VALUES (1, 'Sciences mathématiques, physiques et chimiques')",
            "INSERT INTO PharmaSection(section, sectionTitle) VALUES (2, 'Sciences de la Vie')",
            "INSERT INTO PharmaSection(section, sectionTitle) VALUES (3, 'Sciences de la Santé Publique et de l''Environnement')",
            "INSERT INTO PharmaSection(section, sectionTitle) VALUES (4, 'Eléments de séméiologie et de pathologie. Biologie appliquée à la clinique')",
            "INSERT INTO PharmaSection(section, sectionTitle) VALUES (5, 'Sciences du Médicament')",
            "INSERT INTO PharmaSection(section, sectionTitle) VALUES (6, 'Bactéries et virus')"
    };



    public static final String[] DAO_QUERY_INSERTS_PHARMAFILE_SECTION1 = {
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Méthodes de séparation fondées sur l''extraction (solide-liquide et liquide-liquide).', 1, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Spectrophotométries d''émission et d''absorption atomiques.', 2, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Spectrophotométrie d''absorption moléculaire UV-visible.', 3, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Spectrofluorimétrie moléculaire.', 4, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Méthodes chromatographiques : chromatographie en phase gazeuse ; chromatographie liquide (exclusion-diffusion, échange d''ions, partage).', 5, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Méthodes électrophorétiques y compris les principes des détections.', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Méthodes redox électrochimiques d''analyse y compris les principes des détections : potentiométrie, ampérométrie.', 7, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Pression osmotique : osmolarité, osmolalité.', 8, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Analyse des composés chiraux.', 9, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Principales propriétés structurales et physico-chimiques des fonctions organiques : alcool, phénol, amine, thiol, aldéhyde, cétone et acide carboxylique. Applications à la dérivatisation. Stéréo-isoméries.', 10, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Rayons X et rayonnements émis par les principaux radio-isotopes utilisés in vivo et in vitro.', 11, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Les ions en solution', 12, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Equilibre acide-base en solution aqueuse, pH, pK, solutions tampons.', 12.1, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Réactions et équilibres de complexation.', 12.2, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Protométrie en milieu non aqueux.', 13, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Critères de validité d''une méthode d''analyse : précision, exactitude, linéarité, spécificité, limites de détection et de quantification.', 14, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Méthodes utilisant la réaction antigène-anticorps.', 15, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Statistique descriptive : estimation des paramètres d’une population, intervalle de confiance d’une moyenne et d’une proportion.', 16, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Tests paramétriques de comparaison', 17, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Comparaison unilatérale ou bilatérale', 17.1, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('de deux variances observées', 17.11, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('d’une moyenne observée à une valeur théorique', 17.12, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('de deux moyennes observées', 17.13, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Comparaison unilatérale ou bilatérale dans le cas de grands échantillons :', 17.2, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('d’une proportion observée à une proportion théorique', 17.21, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('de deux proportions observées', 17.22, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Tests de liaison', 18, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Régression linéaire : estimation et intervalle de confiance de la pente et de l’ordonnée à l’origine. Comparaison à une valeur théorique de la pente et de l’ordonnée à l’origine.', 18.1, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Corrélation linéaire : estimation et test du coefficient de corrélation (r).', 18.2, 1)",
            "INSERT INTO PharmaFile(fileTitle, displayOrder, section) VALUES ('Test du Chi-deux d’indépendance.', 18.3, 1)"
    };
    public static final String[] DAO_QUERY_INSERTS_PHARMAFILE_SECTION2 = {
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 1, 'Structure, organisation, dynamique et polymorphisme du génome humain.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 2, 'Régulation de l''expression des gènes codant les protéines chez les eucaryotes.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 3, 'Les différents modes de transmission des maladies héréditaires mendéliennes monogéniques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 4, 'Méthodes d''identification des mutations délétères à l''origine des maladies héréditaires mendéliennes monogéniques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 5, 'Mécanismes et conséquences des mutations délétères à l''origine des maladies héréditaires mendéliennes monogéniques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 6, 'Le caryotype et les anomalies chromosomiques constitutionnelles.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 7, 'Mesure d''une activité enzymatique, applications.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 8, 'Ammoniogenèse et uréogenèse.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 9, 'Structure, biosynthèse et catabolisme des hémoglobines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 10, 'Structure et propriétés des acides nucléiques, des lipoprotéines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 11, 'Régulation de la glycémie.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 12, 'Métabolisme des acides gras, des triglycérides, du cholestérol, des lipoprotéines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 13, 'Cétogenèse.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 14, 'Neurotransmetteurs : acétylcholine, acide gamma-aminobutyrique, adrénaline, dopamine, noradrénaline, sérotonine, glutamate.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 15, 'Physiologie cardiovasculaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 16, 'Physiologie de la respiration.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 17, 'Physiologie digestive.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 18, 'Physiologie rénale.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 19, 'Physiologie des corticosurrénales.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 20, 'Physiologie de la thyroïde.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 21, 'Cycle menstruel et physiologie de la grossesse.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 22, 'Physiologie de la douleur.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 23, 'Physiologie osseuse, régulation de la calcémie et de la phosphatémie.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 24, 'Physiologie des lignées myéloïdes.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 25, 'Groupes sanguins A, B, O, systèmes Rhésus et Kell.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 26, 'Physiologie de l''hémostase primaire, de la coagulation, de la fibrinolyse.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 27, 'Structure et propriétés des immunoglobulines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 28, 'Immunité innée et inflammation.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 29, 'Complexe majeur d''histocompatibilité et présentation de l''antigène.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 30, 'Organes et cellules de la réponse immunitaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (2, 31, 'Réponses immunitaires humorales et cellulaires et leur régulation.')"
    };

    public static final String[] DAO_QUERY_INSERTS_PHARMAFILE_SECTION3 = {
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 1, 'Surveillance sanitaire et vigilances : définition, objectifs et organisation.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 2, 'Prévention et promotion de la santé.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 3, 'Politique vaccinale : élaboration, recommandations et évaluation.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 4, 'Conduites addictives : prévention et prise en charge.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 5, 'Méthodologie épidémiologique :')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 5.1, 'Epidémiologie descriptive : objectifs, enquêtes, indicateurs')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 5.2, 'Test du Chi-deux d''indépendance.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 5.3, 'Epidémiologie étiologique : objectifs, enquêtes, indicateurs')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 5.4, 'Epidémiologie évaluative et dépistage')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 6, 'Médicaments et dispositifs médicaux : définitions, statuts et aspects socio-économiques à l''hôpital.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 7, 'Etablissements de santé, structures de tutelle, pharmacies à usage intérieur.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 8, 'Droits des patients.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 9, 'Risque iatrogène. Risque nosocomial.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 10, 'Risques sanitaires liés aux caractéristiques physico-chimiques et microbiologiques des eaux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 11, 'Toxicologie de l''éthanol, du méthanol, de l''éthylène-glycol et des éthers de glycols.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 12, 'Toxicologie des hydrocarbures aromatiques (benzène, toluène, hydrocarbures aromatiques polycycliques), des solvants chlorés aliphatiques et des dioxines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 13, 'Toxicologie des produits phytosanitaires : organophosphorés, carbamates.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 14, 'Poisons hémolytiques. Poisons de l''hémoglobine : oxyde de carbone, plomb, methémoglobinisants.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 15, 'Toxicologie des radioéléments.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (3, 16, 'Toxicomanies : opiacés, LSD, cocaïne, amphétaminiques, cannabis.')"
    };

    public static final String[] DAO_QUERY_INSERTS_PHARMAFILE_SECTION4 = {
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 1, 'Infections du système nerveux central. ')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 2, 'Bactériémies et endocardites.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 3, 'Infections urinaires.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 4, 'Infections du tube digestif.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 5, 'Infections ORL et bronchopulmonaires. 6. Infections sexuellement transmissibles. ')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 6, 'Infections et grossesse.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 7, 'Infections virales hépatiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 8, 'Infections de l''immunodéprimé.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 9, 'Principe de la détermination de la sensibilité et de la résistance des bactéries et des virus aux agents anti-infectieux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 10, 'Mécanismes de résistance aux agents anti-infectieux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 11, 'Protozooses intestinales : amibiase (entamoebose), giardiose. ')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 12, 'Trichomonose urogénitale.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 13, 'Paludisme.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 14, 'Toxoplasmose.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 15, 'Leishmaniose à Leishmania infantum.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 16, 'Helminthoses intestinales et hépatiques : fasciolose à Fasciola hepatica, bilharziose à Schistosoma mansoni, téniasis à Taenia saginata, hydatidose à Echinococcus granulosus, oxyurose, anguillulose.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 17, 'Infections à levures (Candida albicans, Cryptococcus neoformans).')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 18, 'Infections à Aspergillus fumigatus.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 19, 'Infections à dermatophytes (Microsporum canis, Trichophyton rubrum, Trichophyton mentagrophytes).')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 20, 'Pneumocystose à Pneumocystis jirovecii.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 21, 'Anémies carentielles. Anémies hémolytiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 22, 'Polyglobulies.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 23, 'Leucémie myéloïde chronique.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 24, 'Hémophilies. Maladie de Willebrand.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 25, 'Hémoglobinopathies : drépanocytose, thalassémies.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 26, 'Myélome et dysglobulinémies monoclonales de signification indéterminée.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 27, 'Leucémies aiguës et syndromes myélodysplasiques (hors classifications).')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 28, 'Hyperlymphocytoses : syndromes mononucléosiques, leucémie lymphoïde')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 29, 'chronique, lymphomes (hors classifications).')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 30, 'Cytopénies médicamenteuses.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 31, 'Thrombopénies.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 32, 'Asthme et allergies.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 33, 'Maladies auto-immunes : polyarthrite rhumatoïde et lupus systémique. 34. Déficits immunitaires congénitaux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 34, 'Exploration des réactions inflammatoires.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 35, 'Diagnostic d''un allongement du temps de Quick et/ou du temps de céphaline avec activateur.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 36, 'Surveillance biologique d''un traitement par les héparines et les antivitamines K.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 37, 'Les produits sanguins labiles : définition, indications, conduite prétransfusionnelle.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 38, 'Diabètes de types 1 et 2.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 39, 'Hyperlipoprotéinémies.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 40, 'Troubles de l''équilibre hydro-électrolytique.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 41, 'Troubles de l''équilibre acidobasique.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 42, 'Troubles du métabolisme osseux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 43, 'Cholestase, cytolyse hépatique, insuffisance hépatocellulaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 44, 'Troubles du métabolisme du fer.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 45, 'Insuffisances rénales, syndrome néphrotique.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 46, 'Accidents coronariens aigus, insuffisance cardiaque.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 47, 'Hyperuricémies.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 48, 'Pancréatite aiguë.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 49, 'Dysfonctionnements corticosurrénaliens.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 50, 'Dysfonctionnements thyroïdiens.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 51, 'Dénutrition protéino-énergétique.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 52, 'Affections neurologiques et neurodégénératives : épilepsie, migraines, algies')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 53, 'faciales – maladie d''Alzheimer, maladie de Parkinson, sclérose en plaques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 54, 'Examen des caractéristiques génétiques d''une personne à des fins médicales.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (4, 55, 'Diagnostic prénatal des maladies génétiques.')"
    };

    public static final String[] DAO_QUERY_INSERTS_PHARMAFILE_SECTION5 = {
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 1, 'Principales étapes : résorption, distribution, biotransformation, excrétion.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 2, 'Facteurs influençant le sort des principes actifs : facteurs physiologiques, états pathologiques, xénobiotiques associés.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 3, 'Biodisponibilité : définition, principe des méthodes d''étude et facteurs de variation.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 4, 'Principaux paramètres pharmacocinétiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 5, 'Cibles des médicaments, caractéristiques des liaisons aux récepteurs, méthodes d''études.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 6, 'Courbe effet-dose, dose efficace 50, notion de marge thérapeutique.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 7, 'Médicaments des affections neurologiques et neurodégénératives : épilepsie, migraines, algies faciales – maladie d''Alzheimer, maladie de Parkinson, sclérose en plaques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 8, 'Antalgiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 9, 'Antipsychotiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 10, 'Anxiolytiques et médicaments des troubles du sommeil.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 11, 'Antidépresseurs. Normothymiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 12, 'Médicaments de l''insuffisance cardiaque.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 13, 'Anti-angoreux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 14, 'Antihypertenseurs.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 15, 'Diurétiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 16, 'Médicaments des troubles de l''hémostase : anticoagulants, anti-agrégants plaquettaires, thrombolytiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 17, 'Solutés de remplissage vasculaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 18, 'Médicaments des troubles du rythme cardiaque.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 19, 'Anti-asthmatiques et anti-allergiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 20, 'Anti-inflammatoires')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 21, 'Médicaments de la goutte.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 22, 'Antidiabétiques : antidiabétiques oraux et insulines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 23, 'Sulfamides antibactériens et associations.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 24, 'béta-lactames.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 25, 'Macrolides et apparentés.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 26, 'Cyclines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 27, 'Aminosides.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 28, 'Glycopeptides.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 29, 'Quinolones.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 30, 'Antituberculeux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 31, 'Antirétroviraux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 32, 'Antiviraux actifs contre les virus des hépatites, les virus grippaux et les virus du groupe herpès.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 33, 'Antifongiques par voie générale.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 34, 'Antiprotozoaires intestinaux et anthelminthiques intestinaux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 35, 'Antimalariques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 36, 'Médicaments de l''ulcère gastro-duodénal.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 37, 'Anti-émétiques.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 38, 'Immunosuppresseurs.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 39, 'Facteurs de croissance hématopoïétiques. Cytokines et antagonistes.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 40, 'Médicaments des dysfonctionnements thyroïdiens.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 41, 'Normolipémiants.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 42, 'Anticancéreux : classification et mécanismes d''action, principes de leur utilisation thérapeutique et traitements associés.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 43, 'Médicaments de l''ostéoporose.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 44, 'Méthodes d''évaluation de la toxicité d''un médicament.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 45, 'Toxicologie systémique : mécanismes et manifestations d''une action toxique hématologique, hépatique, rénale, cardiovasculaire ou pulmonaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 46, 'Toxicologie des psychotropes : lithium, benzodiazépines, carbamates, neuroleptiques, antidépresseurs.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 47, 'Toxicologie des antalgiques : salicylés, paracétamol et morphinomimétiques. ')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 48, 'Médicaments cardiotoxiques : digoxine, chloroquine.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 49, 'Principes généraux des méthodes de traitement des intoxications. Antidotes.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 50, 'Stérilisation et conditionnement aseptique des médicaments.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 51, 'Formes à libération conventionnelle destinées aux voies orale et parentérale.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 52, 'Formes à libération et/ou distribution modifiées destinées aux voies orale et parentérale.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 53, 'Préparations de nutrition parentérale.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 54, 'Formes destinées aux voies nasale et pulmonaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 55, 'Formes destinées aux voies cutanée (y compris transdermique) et oculaire.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 56, 'Médicaments dérivés du plasma : albumine, facteurs de l''hémostase et immunoglobulines.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 57, 'Vaccins : hépatite B, ROR (rubéole-oreillons-rougeole), tétanos, grippe. ')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 58, 'Anticorps monoclonaux.')",
            "INSERT INTO PharmaFile(section, displayOrder, fileTitle) VALUES (5, 59, 'Cellules souches hématopoïétiques.')"

    };

    public static final String[] DAO_QUERY_INSERTS_PHARMAFILE_BACTEROVIRUS = {
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Neisseria meningitidis', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Neisseria gonorrhoeae', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Staphylococcus aureus', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Streptococcus pyogenes', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Streptococcus agalactiae', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Streptococcus pneumoniae', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Escherichia coli', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Salmonella spp.', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Shigella spp.', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Campylobacter jejuni', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Helicobacter pylori', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Pseudomonas aeruginosa', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Haemophilus influenzae', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Clostridium difficile', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Listeria monocytogenes', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Mycobacterium tuberculosis', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Treponema pallidum', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Chlamydia trachomatis', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('Legionella pneumophila', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus de l''herpès simplex', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('cytomégalovirus', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('entérovirus', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('rotavirus', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('papillomavirus', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus de la grippe', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus de la rubéole', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus des hépatites A', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus des hépatites B', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus des hépatites C', 6, 1)",
            "INSERT INTO PharmaFile(fileTitle, section, displayOrder) VALUES ('virus de l''immunodéficience humaine. ', 6, 1)"
    };

    public static final String[][] DAO_QUERY_INSERTS_PHARMAFILES = {DAO_QUERY_INSERTS_PHARMAFILE_SECTION1,
            DAO_QUERY_INSERTS_PHARMAFILE_SECTION2,
            DAO_QUERY_INSERTS_PHARMAFILE_SECTION3,
            DAO_QUERY_INSERTS_PHARMAFILE_SECTION4,
            DAO_QUERY_INSERTS_PHARMAFILE_SECTION5,
            DAO_QUERY_INSERTS_PHARMAFILE_BACTEROVIRUS
    };


}
