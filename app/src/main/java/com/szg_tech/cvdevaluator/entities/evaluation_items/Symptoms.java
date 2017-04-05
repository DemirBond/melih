package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.MinutesSecondsEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class Symptoms extends SectionEvaluationItem {
    Symptoms(Context context) {
        super(context, ConfigurationParams.SYMPTOMS, null, false);
        name = context.getString(R.string.symptoms);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(context, ConfigurationParams.DYSPNEA, context.getString(R.string.dyspnea), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.OUTPATIENT, context.getString(R.string.outpatient), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EMERGENCY_ROOM, context.getString(R.string.emergency_room), false));
                        add(new BoldEvaluationItem(context, ConfigurationParams.IN_HOSPITAL, context.getString(R.string.in_hospital), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY1, context.getString(R.string.day1), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY2, context.getString(R.string.day2), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY3, context.getString(R.string.day3), false));
                        add(new EmptyCellEvaluationItem());
                        add(new BoldEvaluationItem(context, ConfigurationParams.PLEASE_SELECT_ONE, context.getString(R.string.please_select_one), true));
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.CHRONIC_HF, context.getString(R.string.chronic_hf), ConfigurationParams.PLEASE_SELECT_ONE, false, false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NEW_HF, context.getString(R.string.new_hf), ConfigurationParams.PLEASE_SELECT_ONE, false, false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DYSPNEA_ON_EXERTION, context.getString(R.string.dyspnea_on_exertion), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.STRENUOUS_EXERTION, context.getString(R.string.strenuous_exertion), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MORE_THAN_DAILY_ROUTINE, context.getString(R.string.more_than_daily_routine), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DAILY_ROUTINE_MINIMAL_ACTIVITIES, context.getString(R.string.daily_routine_minimal_activities), false));
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_AT_REST, context.getString(R.string.dyspnea_at_rest), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, context.getString(R.string.weight_gain), false));
                    }
                }, SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.CHEST_PAIN, context.getString(R.string.chest_pain), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.EMERGENCY_ROOM_CP, context.getString(R.string.emergency_room), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TWO_TYPICAL_OR_PROBABLE_ANGINA, context.getString(R.string.two_typical_or_probable_angina), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TYPICAL_OR_PROBABLE_ANGINA_MORE_20_MIN, context.getString(R.string.typical_or_probable_angina_more_20_min), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ASA_USE_IN_PAST_1_WEEK, context.getString(R.string.asa_use_in_past_1_week), false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.POSITIVE_TROPONIN, context.getString(R.string.positive_troponin), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TROPONIN_X_MORE_3_ABOVE_NORMAL, context.getString(R.string.troponin_x_more_3_above_normal), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TROPONIN_1_3_ABOVE_NORMAL, context.getString(R.string.troponin_1_3_above_normal), false));
                                    }
                                }));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.TYPICAL_ANGINA_NEW, context.getString(R.string.typical_angina_new), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ESCALATING_IN_FREQUENCY, context.getString(R.string.escalating_in_frequency), false));
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PROBABLY_ANGINA_NEW, context.getString(R.string.probably_angina_new), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.UNDETERMINED_CP_NEW, context.getString(R.string.undetermined_cp_new), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SIDE_HEMITHORAX, context.getString(R.string.side_hemithorax), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(context, ConfigurationParams.QUALITY, context.getString(R.string.quality), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHARP, context.getString(R.string.sharp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRESSURE, context.getString(R.string.pressure), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TIGHTNESS, context.getString(R.string.tightness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.AGGRAVATED_BY, context.getString(R.string.aggravated_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING, context.getString(R.string.lying), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BREATHING, context.getString(R.string.breathing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.COUGHING, context.getString(R.string.coughing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTION, context.getString(R.string.exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RELIEVED_BY, context.getString(R.string.relieved_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NTG, context.getString(R.string.ntg), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.REST, context.getString(R.string.rest), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SITTING_UP, context.getString(R.string.sitting_up), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING_ON_SIDE, context.getString(R.string.lying_on_side), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANALGESICS, context.getString(R.string.analgesics), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RADIATION, context.getString(R.string.radiation), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JAW, context.getString(R.string.jaw), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BACK, context.getString(R.string.back), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ARM, context.getString(R.string.arm), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_WITH, context.getString(R.string.associated_with), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_CP, context.getString(R.string.dyspnea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA, context.getString(R.string.nausea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIAPHORESIS, context.getString(R.string.diaphoresis), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAINTNESS, context.getString(R.string.faintness), false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.INTERCOSTAL_CP, context.getString(R.string.intercostal_cp), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(context, ConfigurationParams.QUALITY, context.getString(R.string.quality), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHARP, context.getString(R.string.sharp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRESSURE, context.getString(R.string.pressure), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TIGHTNESS, context.getString(R.string.tightness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.AGGRAVATED_BY, context.getString(R.string.aggravated_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING, context.getString(R.string.lying), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BREATHING, context.getString(R.string.breathing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.COUGHING, context.getString(R.string.coughing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTION, context.getString(R.string.exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RELIEVED_BY, context.getString(R.string.relieved_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NTG, context.getString(R.string.ntg), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.REST, context.getString(R.string.rest), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SITTING_UP, context.getString(R.string.sitting_up), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING_ON_SIDE, context.getString(R.string.lying_on_side), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANALGESICS, context.getString(R.string.analgesics), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RADIATION, context.getString(R.string.radiation), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JAW, context.getString(R.string.jaw), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BACK, context.getString(R.string.back), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ARM, context.getString(R.string.arm), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_WITH, context.getString(R.string.associated_with), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_CP, context.getString(R.string.dyspnea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA, context.getString(R.string.nausea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIAPHORESIS, context.getString(R.string.diaphoresis), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAINTNESS, context.getString(R.string.faintness), false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CENTRAL_PRECORDIAL_CP, context.getString(R.string.central_precordial_cp), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(context, ConfigurationParams.QUALITY, context.getString(R.string.quality), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHARP, context.getString(R.string.sharp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRESSURE, context.getString(R.string.pressure), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TIGHTNESS, context.getString(R.string.tightness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.AGGRAVATED_BY, context.getString(R.string.aggravated_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING, context.getString(R.string.lying), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BREATHING, context.getString(R.string.breathing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.COUGHING, context.getString(R.string.coughing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTION, context.getString(R.string.exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RELIEVED_BY, context.getString(R.string.relieved_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NTG, context.getString(R.string.ntg), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.REST, context.getString(R.string.rest), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SITTING_UP, context.getString(R.string.sitting_up), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING_ON_SIDE, context.getString(R.string.lying_on_side), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANALGESICS, context.getString(R.string.analgesics), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RADIATION, context.getString(R.string.radiation), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JAW, context.getString(R.string.jaw), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BACK, context.getString(R.string.back), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ARM, context.getString(R.string.arm), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_WITH, context.getString(R.string.associated_with), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_CP, context.getString(R.string.dyspnea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA, context.getString(R.string.nausea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIAPHORESIS, context.getString(R.string.diaphoresis), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAINTNESS, context.getString(R.string.faintness), false));
                                    }
                                }));
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UNABLE_TO_EXERCISE, context.getString(R.string.unable_to_exercise), false));

                    }
                }, SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYNCOPE_PRESYNCOPE, context.getString(R.string.syncope_presyncope), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BoldEvaluationItem(context, ConfigurationParams.CIRCUMSTANCE, context.getString(R.string.circumstance), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UPRIGHT_POSITION, context.getString(R.string.upright_position), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SUDDEN_NOISE, context.getString(R.string.sudden_noise), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NECK_MOVEMENT_MANIPULATION, context.getString(R.string.neck_movement_manipulation), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTIONAL, context.getString(R.string.exertional), false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.PRODROMAL_SYMPTOMS, context.getString(R.string.prodromal_symptoms), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA_SYN, context.getString(R.string.nausea), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIZZINESS, context.getString(R.string.dizziness), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPITATIONS, context.getString(R.string.palpitations), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHEST_PAIN, context.getString(R.string.chest_pain), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.AURA, context.getString(R.string.aura), false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.SYNCOPE_DURATION_DURING_SYNCOPE, context.getString(R.string.syncope_duration_during_syncope), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new MinutesSecondsEvaluationItem(context, ConfigurationParams.DURATION));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CYANOSIS, context.getString(R.string.cyanosis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALLOR_DIAPHORESIS, context.getString(R.string.pallor_diaphoresis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UNUSUAL_POSTURE, context.getString(R.string.unusual_posture), false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.POSTICTAL_SYMPTOMS, context.getString(R.string.postictal_symptoms), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DISORIENTATION, context.getString(R.string.disorientation), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PARALYSIS, context.getString(R.string.paralysis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHEST_PAIN_POS_CP, context.getString(R.string.chest_pain), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PROLONGED_FATIGUE, context.getString(R.string.prolonged_fatigue), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TRAUMATIC_INJURY, context.getString(R.string.traumatic_injury), false));
                    }
                }));
            }
        };
    }
}
