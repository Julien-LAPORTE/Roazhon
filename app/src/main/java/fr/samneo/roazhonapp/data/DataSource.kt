package fr.samneo.roazhonapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import fr.samneo.roazhonapp.R
import fr.samneo.roazhonapp.model.PointOfInterest
import fr.samneo.roazhonapp.model.PointOfInterest.CoffeeShop
import fr.samneo.roazhonapp.model.PointOfInterest.GasStation
import fr.samneo.roazhonapp.model.PointOfInterest.Gym
import fr.samneo.roazhonapp.model.PointOfInterest.Mall
import fr.samneo.roazhonapp.model.PointOfInterest.Park
import fr.samneo.roazhonapp.model.PointOfInterest.Restaurant

object DataSource {

    enum class Category(@StringRes val title: Int, @DrawableRes val picture: Int) {
        RESTAURANTS(R.string.restaurants, R.drawable.restaurants),
        COFFEE_SHOPS(R.string.coffee_shops, R.drawable.coffee_shops),
        PARKS(R.string.parks, R.drawable.parks),
        MALLS(R.string.malls, R.drawable.malls),
        GAS_STATIONS(R.string.gas_stations, R.drawable.gas_stations),
        GYMS(R.string.gyms, R.drawable.gyms)
    }

    private object Restaurants {
        val cafeBreton = Restaurant(
            name = "Café Breton", description = R.string.café_breton_description, photos = listOf(
                R.drawable.restaurants_cafe_breton_01,
                R.drawable.restaurants_cafe_breton_02,
                R.drawable.restaurants_cafe_breton_03,
                R.drawable.restaurants_cafe_breton_04,
                R.drawable.restaurants_cafe_breton_05,
                R.drawable.restaurants_cafe_breton_06,
                R.drawable.restaurants_cafe_breton_07
            )
        )
        val leBistrotDesRemparts = Restaurant(
            name = "Le bistrot des remparts",
            description = R.string.le_bistrot_des_remparts_description,
            photos = listOf(
                R.drawable.restaurants_le_bistrot_des_remparts_01,
                R.drawable.restaurants_le_bistrot_des_remparts_02,
                R.drawable.restaurants_le_bistrot_des_remparts_03,
                R.drawable.restaurants_le_bistrot_des_remparts_04
            )
        )
        val racines = Restaurant(
            name = "Racines", description = R.string.Racines_description, photos = listOf(
                R.drawable.restaurants_racines_01,
                R.drawable.restaurants_racines_02,
                R.drawable.restaurants_racines_03,
                R.drawable.restaurants_racines_04,
                R.drawable.restaurants_racines_05,
                R.drawable.restaurants_racines_06
            )
        )
        val leGlobe = Restaurant(
            name = "Le globe", description = R.string.le_globe_description, photos = listOf(
                R.drawable.restaurants_le_globe_01,
                R.drawable.restaurants_le_globe_02,
                R.drawable.restaurants_le_globe_03,
                R.drawable.restaurants_le_globe_04,
                R.drawable.restaurants_le_globe_05,
                R.drawable.restaurants_le_globe_06
            )
        )
        val laReserve = Restaurant(
            name = "La reserve", description = R.string.la_reserve_description, photos = listOf(
                R.drawable.restaurants_la_reserve_01,
                R.drawable.restaurants_la_reserve_02,
                R.drawable.restaurants_la_reserve_03,
                R.drawable.restaurants_la_reserve_04,
                R.drawable.restaurants_la_reserve_05
            )
        )
        val lAoc = Restaurant(
            name = "L'AOC Rennes", description = R.string.l_aoc_rennes_description, photos = listOf(
                R.drawable.restaurants_l_aoc_01,
                R.drawable.restaurants_l_aoc_02,
                R.drawable.restaurants_l_aoc_03
            )
        )
        val allRestaurants = listOf(
            cafeBreton, leBistrotDesRemparts, racines, leGlobe, laReserve, lAoc
        )
    }

    private object CoffeeShops {
        val bakeryKafe = CoffeeShop(
            name = "Bakery Kafé", description = R.string.bakery_kafé_description, photos = listOf(
                R.drawable.coffee_shops_bakery_kafe_01,
                R.drawable.coffee_shops_bakery_kafe_02,
                R.drawable.coffee_shops_bakery_kafe_03,
                R.drawable.coffee_shops_bakery_kafe_04,
                R.drawable.coffee_shops_bakery_kafe_05,
                R.drawable.coffee_shops_bakery_kafe_06,
                R.drawable.coffee_shops_bakery_kafe_07,
                R.drawable.coffee_shops_bakery_kafe_08,
                R.drawable.coffee_shops_bakery_kafe_09,
                R.drawable.coffee_shops_bakery_kafe_10,
                R.drawable.coffee_shops_bakery_kafe_11,
                R.drawable.coffee_shops_bakery_kafe_12,
                R.drawable.coffee_shops_bakery_kafe_13,
                R.drawable.coffee_shops_bakery_kafe_14,
                R.drawable.coffee_shops_bakery_kafe_15
            )
        )
        val bourbonDArsel = CoffeeShop(
            name = "Bourbon D'Arsel",
            description = R.string.bourbon_d_arsel_description,
            photos = listOf(
                R.drawable.coffee_shops_bourbon_d_arsel_01,
                R.drawable.coffee_shops_bourbon_d_arsel_02,
                R.drawable.coffee_shops_bourbon_d_arsel_03,
                R.drawable.coffee_shops_bourbon_d_arsel_04,
                R.drawable.coffee_shops_bourbon_d_arsel_05,
                R.drawable.coffee_shops_bourbon_d_arsel_06,
                R.drawable.coffee_shops_bourbon_d_arsel_07,
                R.drawable.coffee_shops_bourbon_d_arsel_08
            )
        )
        val mokkaCoffeeHouse = CoffeeShop(
            name = "Mokka Coffee House",
            description = R.string.mokka_coffee_house_description,
            photos = listOf(
                R.drawable.coffee_shops_mokka_coffee_house_01,
                R.drawable.coffee_shops_mokka_coffee_house_02,
                R.drawable.coffee_shops_mokka_coffee_house_03,
                R.drawable.coffee_shops_mokka_coffee_house_04,
                R.drawable.coffee_shops_mokka_coffee_house_05,
                R.drawable.coffee_shops_mokka_coffee_house_06
            )
        )
        val columbusCafeAndCo = CoffeeShop(
            name = "Columbus café & co",
            description = R.string.columbus_café_and_co_description,
            photos = listOf(
                R.drawable.coffee_shops_columbus_cafe_and_co_01,
                R.drawable.coffee_shops_columbus_cafe_and_co_02,
                R.drawable.coffee_shops_columbus_cafe_and_co_03,
                R.drawable.coffee_shops_columbus_cafe_and_co_04,
                R.drawable.coffee_shops_columbus_cafe_and_co_05,
                R.drawable.coffee_shops_columbus_cafe_and_co_06
            )
        )
        val cafe1802 = CoffeeShop(
            name = "Café 1802", description = R.string.café_1802_description, photos = listOf(
                R.drawable.coffee_shops_cafe_1802_01,
                R.drawable.coffee_shops_cafe_1802_02,
                R.drawable.coffee_shops_cafe_1802_03,
                R.drawable.coffee_shops_cafe_1802_04,
                R.drawable.coffee_shops_cafe_1802_05,
                R.drawable.coffee_shops_cafe_1802_06,
                R.drawable.coffee_shops_cafe_1802_07,
                R.drawable.coffee_shops_cafe_1802_08
            )
        )

        val allCoffeeShop = listOf(
            bakeryKafe, bourbonDArsel, mokkaCoffeeHouse, columbusCafeAndCo, cafe1802
        )
    }

    private object Parks {
        val parcDeMaurepas = Park(
            name = "Parc de maurepas",
            description = R.string.parc_de_maurepas_description,
            photos = listOf(
                R.drawable.parks_parc_de_maurepas_01,
                R.drawable.parks_parc_de_maurepas_02,
                R.drawable.parks_parc_de_maurepas_03,
                R.drawable.parks_parc_de_maurepas_04,
                R.drawable.parks_parc_de_maurepas_05,
                R.drawable.parks_parc_de_maurepas_06,
                R.drawable.parks_parc_de_maurepas_07,
                R.drawable.parks_parc_de_maurepas_08
            )
        )
        val parcHamelinOberthur = Park(
            name = "Parc Hamelin Obertür",
            description = R.string.parc_hamelin_oberthür_description,
            photos = listOf(
                R.drawable.parks_parc_hamelin_oberthur_01,
                R.drawable.parks_parc_hamelin_oberthur_02,
                R.drawable.parks_parc_hamelin_oberthur_03,
                R.drawable.parks_parc_hamelin_oberthur_04,
                R.drawable.parks_parc_hamelin_oberthur_05,
                R.drawable.parks_parc_hamelin_oberthur_06
            )
        )
        val parcDeBrequigny = Park(
            name = "Parc de brequigny",
            description = R.string.parc_de_bréquigny_description,
            photos = listOf(
                R.drawable.parks_parc_de_brequigny_01,
                R.drawable.parks_parc_de_brequigny_02,
                R.drawable.parks_parc_de_brequigny_03,
                R.drawable.parks_parc_de_brequigny_04,
                R.drawable.parks_parc_de_brequigny_05,
                R.drawable.parks_parc_de_brequigny_06,
                R.drawable.parks_parc_de_brequigny_07
            )
        )
        val parcDesGayeulles = Park(
            name = "Parc des gayeulles",
            description = R.string.parc_des_gayeulles_description,
            photos = listOf(
                R.drawable.parks_parc_des_gayeulles_01,
                R.drawable.parks_parc_des_gayeulles_02,
                R.drawable.parks_parc_des_gayeulles_03,
                R.drawable.parks_parc_des_gayeulles_04,
                R.drawable.parks_parc_des_gayeulles_05,
                R.drawable.parks_parc_des_gayeulles_06,
                R.drawable.parks_parc_des_gayeulles_07
            )
        )
        val parcDuThabor = Park(
            name = "Parc du thabor",
            description = R.string.parc_du_thabor_description,
            photos = listOf(
                R.drawable.parks_parc_du_thabor_01,
                R.drawable.parks_parc_du_thabor_02,
                R.drawable.parks_parc_du_thabor_03,
                R.drawable.parks_parc_du_thabor_04,
                R.drawable.parks_parc_du_thabor_05,
                R.drawable.parks_parc_du_thabor_06
            )
        )
        val allParks = listOf<Park>(
            parcDeMaurepas, parcHamelinOberthur, parcDeBrequigny, parcDesGayeulles, parcDuThabor
        )
    }

    private object Malls {
        val saintGregoireLeCentre = Mall(
            name = "Saint Grégoire le centre",
            description = R.string.saint_grégoire_le_centre_description,
            photos = listOf(
                R.drawable.malls_saint_gregoire_le_centre_01,
                R.drawable.malls_saint_gregoire_le_centre_02,
                R.drawable.malls_saint_gregoire_le_centre_03,
                R.drawable.malls_saint_gregoire_le_centre_04,
                R.drawable.malls_saint_gregoire_le_centre_05,
                R.drawable.malls_saint_gregoire_le_centre_06
            )
        )
        val grandQuartier = Mall(
            name = "Grand quartier",
            description = R.string.grand_quartier_description,
            photos = listOf(
                R.drawable.malls_grand_quartier_01,
                R.drawable.malls_grand_quartier_02,
                R.drawable.malls_grand_quartier_03,
                R.drawable.malls_grand_quartier_04,
                R.drawable.malls_grand_quartier_05,
                R.drawable.malls_grand_quartier_06
            )
        )
        val laVisitation = Mall(
            name = "La visitation",
            description = R.string.la_visitation_description,
            photos = listOf(
                R.drawable.malls_la_visitation_01, R.drawable.malls_la_visitation_02
            )
        )
        val colombia = Mall(
            name = "Colombia", description = R.string.colombia_description, photos = listOf(
                R.drawable.malls_colombia_01,
                R.drawable.malls_colombia_02,
                R.drawable.malls_colombia_03,
                R.drawable.malls_colombia_04,
                R.drawable.malls_colombia_05
            )
        )
        val alma = Mall(
            name = "Alma", description = R.string.alma_description, photos = listOf(
                R.drawable.malls_alma_01,
                R.drawable.malls_alma_02,
                R.drawable.malls_alma_03,
                R.drawable.malls_alma_04,
                R.drawable.malls_alma_05,
                R.drawable.malls_alma_06
            )
        )
        val allMalls = listOf<Mall>(
            saintGregoireLeCentre, grandQuartier, laVisitation, colombia, alma
        )
    }

    private object GasStations {
        val intermarcheStationService = GasStation(
            name = "Intermarché Station Service",
            description = R.string.intermarché_station_service_description,
            photos = listOf(
                R.drawable.gas_stations_intermarche_station_service_01,
                R.drawable.gas_stations_intermarche_station_service_02
            )
        )
        val eLeclercStationService = GasStation(
            name = "E.Leclerc Station Service",
            description = R.string.e_leclerc_station_service_description,
            photos = listOf(
                R.drawable.gas_stations_eleclerc_station_service_01,
                R.drawable.gas_stations_eleclerc_station_service_02
            )
        )
        val accessTotalEnergie = GasStation(
            name = "Access Total Energie",
            description = R.string.access_total_energies_description,
            photos = listOf(
                R.drawable.gas_stations_access_total_energies_01
            )
        )
        val allGasStations = listOf<GasStation>(
            intermarcheStationService, eLeclercStationService, accessTotalEnergie
        )
    }

    private object Gyms {
        val rbcWorkout = Gym(
            name = "RBC Workout", description = R.string.rbc_workout_description, photos = listOf(
                R.drawable.gyms_rbc_workout_01,
                R.drawable.gyms_rbc_workout_02,
                R.drawable.gyms_rbc_workout_03,
                R.drawable.gyms_rbc_workout_04,
                R.drawable.gyms_rbc_workout_05,
                R.drawable.gyms_rbc_workout_06,
                R.drawable.gyms_rbc_workout_07,
                R.drawable.gyms_rbc_workout_08,
                R.drawable.gyms_rbc_workout_09,
                R.drawable.gyms_rbc_workout_10,
                R.drawable.gyms_rbc_workout_11,
                R.drawable.gyms_rbc_workout_12,
                R.drawable.gyms_rbc_workout_13
            )
        )
        val vanillaFitness = Gym(
            name = "Vanilla Fitness",
            description = R.string.vanilla_fitness_description,
            photos = listOf(
                R.drawable.gyms_vanilla_fitness_01,
                R.drawable.gyms_vanilla_fitness_02,
                R.drawable.gyms_vanilla_fitness_03,
                R.drawable.gyms_vanilla_fitness_04,
                R.drawable.gyms_vanilla_fitness_05,
                R.drawable.gyms_vanilla_fitness_06,
                R.drawable.gyms_vanilla_fitness_07,
                R.drawable.gyms_vanilla_fitness_08
            )
        )
        val elanciaMaginot = Gym(
            name = "Elancia Maginot",
            description = R.string.elancia_maginot_description,
            photos = listOf(
                R.drawable.gyms_elancia_maginot_01,
                R.drawable.gyms_elancia_maginot_02,
                R.drawable.gyms_elancia_maginot_03,
                R.drawable.gyms_elancia_maginot_04,
                R.drawable.gyms_elancia_maginot_05
            )
        )
        val keepcoolColombier = Gym(
            name = "Keepcool Colombier",
            description = R.string.keepcool_colombier_description,
            photos = listOf(
                R.drawable.gyms_keepcool_colombier_01,
                R.drawable.gyms_keepcool_colombier_02,
                R.drawable.gyms_keepcool_colombier_03,
                R.drawable.gyms_keepcool_colombier_04,
                R.drawable.gyms_keepcool_colombier_05,
                R.drawable.gyms_keepcool_colombier_06
            )
        )
        val bestOfGym = Gym(
            name = "Best Of Gym", description = R.string.best_of_gym_description, photos = listOf(
                R.drawable.gyms_best_of_gym_01,
                R.drawable.gyms_best_of_gym_02,
                R.drawable.gyms_best_of_gym_03,
                R.drawable.gyms_best_of_gym_04,
                R.drawable.gyms_best_of_gym_05,
                R.drawable.gyms_best_of_gym_06,
                R.drawable.gyms_best_of_gym_07,
                R.drawable.gyms_best_of_gym_08,
                R.drawable.gyms_best_of_gym_09
            )
        )
        val allGyms = listOf<Gym>(
            rbcWorkout, vanillaFitness, elanciaMaginot, keepcoolColombier, bestOfGym
        )
    }

    fun getRecommendations(category: Category): List<PointOfInterest> {
        return when (category) {
            Category.RESTAURANTS -> Restaurants.allRestaurants
            Category.COFFEE_SHOPS -> CoffeeShops.allCoffeeShop
            Category.PARKS -> Parks.allParks
            Category.MALLS -> Malls.allMalls
            Category.GAS_STATIONS -> GasStations.allGasStations
            Category.GYMS -> Gyms.allGyms
        }
    }

}