package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class PhysicalExam extends SectionEvaluationItem {
    PhysicalExam(Context context) {
        super(context, ConfigurationParams.PHYSICAL_EXAM, null, false);
        name = context.getString(R.string.physical_exam);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(context, ConfigurationParams.HEPATOJULUAR_REFLUX, context.getString(R.string.hepatojuluar_reflux), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.JUGULAR_VENOUS_DISTENTION, context.getString(R.string.jugular_venous_distention), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.DISPLACED_PMI, context.getString(R.string.displaced_pmi), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.LEFT_SIDED_S3_OR_S4_GALLOP, context.getString(R.string.left_sided_s3_or_s4_gallop), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.FRICTION_RUB, context.getString(R.string.friction_rub), false));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.HEART_MURMUR, context.getString(R.string.heart_murmur), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BoldEvaluationItem(context, ConfigurationParams.FOCUS_ON_THE_MOST_ABNORMAL_AUSCULTATION_FOCI, context.getString(R.string.focus_on_the_most_abnormal_auscultation_foci), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SI_MITRAL, context.getString(R.string.si_mitral), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.LOUD_S1_MITRAL, context.getString(R.string.loud), ConfigurationParams.SI_MITRAL, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NORMAL_S1_MITRAL, context.getString(R.string.normal), ConfigurationParams.SI_MITRAL, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.SOFT_SI_MITRAL, context.getString(R.string.soft), ConfigurationParams.SI_MITRAL, false, false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.S2_AORTIC, context.getString(R.string.s2_aortic), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.LOUD_S2_AORTIC, context.getString(R.string.loud), ConfigurationParams.S2_AORTIC, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NORMAL_S2_AORTIC, context.getString(R.string.normal), ConfigurationParams.S2_AORTIC, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.SOFT_S2_AORTIC, context.getString(R.string.soft), ConfigurationParams.S2_AORTIC, false, false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.P2_PULMONIC, context.getString(R.string.p2_pulmonic), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.LOUD_P2_PULMONIC, context.getString(R.string.loud), ConfigurationParams.P2_PULMONIC, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NORMAL_P2_PULMONIC, context.getString(R.string.normal), ConfigurationParams.P2_PULMONIC, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.SOFT_P2_PULMONIC, context.getString(R.string.soft), ConfigurationParams.P2_PULMONIC, false, false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.S1_TRICUSPID, context.getString(R.string.s1_tricuspid), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.LOUD_S1_TRICUSPID, context.getString(R.string.loud), ConfigurationParams.S1_TRICUSPID, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NORMAL_S1_TRICUSPID, context.getString(R.string.normal), ConfigurationParams.S1_TRICUSPID, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.SOFT_S1_TRICUSPID, context.getString(R.string.soft), ConfigurationParams.S1_TRICUSPID, false, false));
                            }
                        }));
                        add(new SectionEvaluationItem(context, ConfigurationParams.MURMUR, context.getString(R.string.murmur), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYSTOLIC_MURMUR, context.getString(R.string.systolic_murmur), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CRESCENDO_DECRESCENDO, context.getString(R.string.crescendo_decrescendo), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.EARLY_MID_SYSTOLIC_PEAKING, context.getString(R.string.early_mid_systolic_peaking), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.LATE_SYSTOLIC_PEAKING, context.getString(R.string.late_systolic_peaking), false));
                                            }
                                        }));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PLATEAU_SHAPED, context.getString(R.string.plateau_shaped), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.HALOSYSTOLIC, context.getString(R.string.halosystolic), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.PANSYSTOLIC, context.getString(R.string.pansystolic), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.MIDSYSTOLIC, context.getString(R.string.midsystolic), false));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SOFTER_WITH_SQUAT, context.getString(R.string.softer_with_squat), false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DIASTOLIC_MURMUR, context.getString(R.string.diastolic_murmur), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DECRESCENDO, context.getString(R.string.decrescendo), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RUMBLE, context.getString(R.string.rumble), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.MITRAL_OPENING_SNAP, context.getString(R.string.mitral_opening_snap), false));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED) {
                            {
                                setHasStateIcon(false);
                            }
                        });

                    }
                }));
                add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_RALES, context.getString(R.string.new_rales), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.PULMONARY_EDEMA, context.getString(R.string.pulmonary_edema), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.DIMINISHED_BREATH_SOUNDS, context.getString(R.string.diminished_breath_sounds), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.ABDOMINAL_TENDERNESS, context.getString(R.string.abdominal_tenderness), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.ANY_CNS_SYMPTOMS, context.getString(R.string.any_cns_symptoms), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.COLD_CLAMMY_EXTERMITIES, context.getString(R.string.cold_clammy_extermities), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.EDEMA, context.getString(R.string.edema), false));
                add(new NumericalEvaluationItem(context, ConfigurationParams.DIFFERENCE_IN_SBP, context.getString(R.string.difference_in_sbp), context.getString(R.string.value), 0, 50, false, true));
            }
        };
    }
}
